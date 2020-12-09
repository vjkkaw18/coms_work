package hw3;

import java.util.ArrayList;
import java.util.Scanner;

import api.Instruction;
import api.NVPair;
import api.SymbolTable;

/**
 * Assembler for assembly language programs targeting the CS227Comp 
 * machine.  See the associated pdf for a detailed overview.
 */
public class SolutionCS227Asm
{
  /**
   * Symbol table for data.
   */
  private SymbolTable data;
  
  /**
   * Symbol table for labels.
   */
  private SymbolTable labels;
  
  /**
   * Instruction stream.
   */
  private ArrayList<Instruction> instructionStream;
  
  /**
   * The given program to assemble, as a list of strings.
   */
  private ArrayList<String> arr;

  /**
   * Constructs an assembler for the given assembly language program, given 
   * as an ArrayList of strings (one per line of the program).  Initially
   * both symbol tables and the instruction stream are empty.
   * @param program
   *   the assembly language program to be translated
   */
  public SolutionCS227Asm(ArrayList<String> program)
  {
    arr = program;
    data = new SymbolTable();
    labels = new SymbolTable();
    instructionStream = new ArrayList<>();
  }

  /**
   * Returns the symbol table for data (variables).
   * @return
   *   the symbol table for data
   */
  public SymbolTable getData()
  {
    return data;
  }

  /**
   * Returns the symbol table for labels (jump targets).
   * @return
   *   the symbol table for labels
   */
  public SymbolTable getLabels()
  {
    return labels;
  }

  /**
   * Returns the instruction stream. The index of each instruction in the
   * list is its memory location in the generated code.
   * @return
   *   list of machine instructions
   */
  public ArrayList<Instruction> getInstructionStream()
  {
    return instructionStream;
  }

  /**
   * Assembles the source program represented by this assembler instance
   * and returns the generated machine code and data as an array of strings.
   * @return
   *   list of strings containing the machine code and data for the 
   *   program represented by this assembler
   *   
   */
  public ArrayList<String> assemble()
  {
    parseData();
    parseLabels();
    parseInstructions();
    setOperandValues();
    addLabelAnnotations();
    return writeCode();
  }

  /**
   * Creates the symbol table for the data section of this assembler's program.
   */
  public void parseData()
  {
    boolean inDataSection = false;
    for (String s : arr)
    {
      if (s.startsWith("data:"))
      {
        inDataSection = true;
      }
      else if (inDataSection)
      {
        if (s.startsWith("labels:"))
        {
          break;
        }
        Scanner temp = new Scanner(s);
        data.add(temp.next(), temp.nextInt());
      }
    }
  }

  /**
   * Creates the symbol table for the label section of this assembler's
   * program, leaving all label values as zeros.
   */
  public void parseLabels()
  {
    boolean inLabelsSection = false;
    for (String s : arr)
    {
      if (s.startsWith("labels:"))
      {
        inLabelsSection = true;
      }
      else if (inLabelsSection)
      {
        if (s.startsWith("instructions:"))
        {
          break;
        }
        Scanner temp = new Scanner(s);
        labels.add(temp.next());
      }
    }
  }

  /**
   * Creates instruction stream from the instruction section of this 
   * assembler's program and fills in label addresses in the 
   * symbol table for labels.
   */
  public void parseInstructions()
  {
    boolean inInstructionSection = false;
    for (String s : arr)
    {
      if (s.startsWith("instructions:"))
      {
        inInstructionSection = true;
      }
      else if (inInstructionSection)
      {
        int instructionNumber = instructionStream.size();
        
        // grab first token on the line to check whether it's a label
        Scanner temp = new Scanner(s);
        String first = temp.next();
        if (labels.containsName(first))
        {
          // this is a label, does not increment instruction number,
          // just update label value in symbol table
          NVPair p = labels.findByName(first);
          p.setValue(instructionNumber);
        }
        else
        {
          // it's not a label, it's an instruction
          instructionStream.add(new Instruction(s));
        }
      }
    }
  }

  /**
   * Fills in the correct operand value for all instructions 
   * (either a data address or jump target address, depending 
   * on the instruction).
   */
  public void setOperandValues()
  {
    for (Instruction instr : instructionStream)
    {
      if (instr.requiresDataAddress())
      {
        String operandString = instr.getOperandString();
        NVPair p = data.findByName(operandString);
        
        // data address is index in data table plus size of  
        // instruction stream
        int index = data.indexOf(p);
        instr.setOperand(instructionStream.size() + index);
      }
      else if (instr.requiresJumpTarget())
      {
        String operandString = instr.getOperandString();
        NVPair p = labels.findByName(operandString);
        
        // value of label should be the jump address
        instr.setOperand(p.getValue());
      }
      // else it's a halt instruction, has no operand
    }
  }

  /**
   * For each instruction in the instruction stream that is a 
   * jump target, adds the label to the instruction's description.
   * (See the method <code>addLabelToDescription</code> in
   * the <code>Instruction</code> class.)
   */
  public void addLabelAnnotations()
  {
    for (int i = 0; i < labels.size(); ++i)
    {
      NVPair p = labels.getByIndex(i);
      int address = p.getValue();
      String label = p.getName();
      
      // label address is exactly where we want to add the
      // annotation to the instruction
      Instruction instr = instructionStream.get(address);
      instr.addLabelToDescription(label);
    }
  }

  /**
   * Generates the machine code and data for this assembler's program,
   * terminated by the string "-99999".  Strings for instructions are
   * produced by the <code>Instruction</code> method <code>toString</code>,
   * and strings for data have the value formatted as a four-digit signed
   * integer, followed by a space, followed by the variable name.
   * @return
   *   list of strings containing the machine code and data for this 
   *   assembler's program
   */
  public ArrayList<String> writeCode()
  {
    ArrayList<String> result = new ArrayList<>();
    
    // first write the instructions, using the Instruction toString method
    for (Instruction instr : instructionStream)
    {
      result.add(instr.toString());
    }
    
    // then write the data with the required formatting
    for (int i = 0; i < data.size(); ++i)
    {
      NVPair p = data.getByIndex(i);
      String s = String.format("%+05d", p.getValue());
      result.add(s + " " + p.getName());
    }
    result.add("-99999");
    return result;
  }

}
