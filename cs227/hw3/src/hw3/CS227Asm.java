package hw3;

import java.util.ArrayList;
import java.util.Scanner;

import api.Instruction;
import api.NVPair;
import api.SymbolTable;

/**
 * Assembler for assembly language programs targeting the CS227Comp Machine. 
 * An assembler is a program that translates assembly language into machine code
 * using symbolic names for opcodes, data locations (variables) and jump targets.
 * @author Vance Kaw
 */
public class CS227Asm {

	/**
	 * Creates a symbol table for data
	 */
	private SymbolTable data;
	
	/**
	 * Creates a symbol table for labels
	 */
	private SymbolTable labels;
	
	/**
	 * Creates an array list of instructions for instructionStream
	 */
	private ArrayList<Instruction> instructionStream;
	
	/**
	 * Creates an array list of string named lists
	 */
	private ArrayList<String> lists;

	/**
	 * The current size of the instructionStream excluding the jump targets and labels
	 */
	private int count;

	/**
	 * Constructs an assembler for the given assembly language program, given as 
	 * an ArrayList of strings. Initially both symbol tables and the instruction
	 * stream are empty. 
	 * Also, setting the assembly language program to the new array list (lists) created
	 * @param program
	 * the assembly language program to be translated. 
	 */
	public CS227Asm(java.util.ArrayList<java.lang.String> program)
	{ 
		lists = program;
		data = new SymbolTable();
		labels = new SymbolTable();
		instructionStream = new ArrayList<Instruction>();
	}

	/**
	 * For each instruction in the instruction stream that is a jump target, adds 
	 * the label to the instruction's description.
	 * Utilizing the addLabelToDesrciption located in the Instruction class.
	 */
	public void addLabelAnnotations()
	{
		for (int i = 0; i < labels.size(); i++)
		{
			NVPair currentPoint = labels.getByIndex(i); 
			String name = currentPoint.getName();
			int pointValue = currentPoint.getValue(); 
			Instruction temp = instructionStream.get(pointValue);
			temp.addLabelToDescription(name);
		}
	}

	/**
	 * Assembles the source program represented by this assembler instance and 
	 * returns the generated machine code and data as an array of strings. 
	 * By calling all the other methods in this class (CS227Asm) and using 
	 * the writeCode(0 method to return the list of strings. 
	 * @return
	 * list of strings containing the machine code and data for the program 
	 * represented by this assembler. 
	 */
	public java.util.ArrayList<java.lang.String> assemble()
	{
		parseData();
		parseLabels();
		parseInstructions();
		setOperandValues();
		addLabelAnnotations();

		return writeCode();
	}

	/**
	 * Returns the symbol table for data (variables).
	 * @return
	 * the symbol table for data
	 */
	public SymbolTable getData()
	{
		return data;
	}

	/**
	 * Returns the instruction stream. The index of each instruction in the list 
	 * is its memory location in the generated code. 
	 * @return
	 * list of machine instructions.
	 */
	public java.util.ArrayList<Instruction> getInstructionStream()
	{
		return instructionStream;
	}

	/**
	 * Returns the symbol table for labels (jump targets)
	 * @return
	 * the symbol table for labels 
	 */
	public SymbolTable getLabels()
	{
		return labels;
	}

	/**
	 * Creates the symbol table for the data section of this assembler's program.
	 * Adds the strings contained and assigns the value to each string. 
	 * This method should continue adding up until it reaches the string "labels:"
	 */
	public void parseData()
	{
		for (int i = 0; i < lists.size(); i++)
		{
			if (lists.get(i+1).equals("labels:"))
			{
				break;
			}
			else 
			{
				Scanner scanner = new Scanner(lists.get(i+1));
				data.add(scanner.next(), scanner.nextInt());
				scanner.close();
			}	
		}
	}

	/**
	 * Creates the symbol table for the label section of this assembler's program,
	 * leaving all label values as zeros. 
	 * Adds the strings contained in labels. 
	 * This method should continue adding up until it reaches the string "instructions"
	 */
	public void parseLabels()
	{
		for (int i = 0; i < lists.size(); i++)
		{
			if (lists.get(i).equals("labels:"))
			{
				for (int j = i; j < lists.size(); j++)
				{
					if (lists.get(j+1).equals("instructions:"))
					{
						break;
					}
					else 
					{
						Scanner scanner = new Scanner(lists.get(j+1));
						labels.add(scanner.next());
					}
				}
			}
		}
	}


	/**
	 * Creates instruction stream from the instruction section of this assembler's 
	 * program and fills in label addresses in the symbol table for labels. 
	 * Creating a list of Instruction objects and completing the symbol table for labels 
	 * using the locations of the jump targets. 
	 * Instructions are placed in memory starting at address 0. Keeping a count will 
	 * will help what the address associated with that label. 
	 * Labels do not increment the instruction count and are not included in the
	 * instruction list.
	 */
	public void parseInstructions()
	{
		for (int i = 0; i < lists.size(); i++)
		{
			if (lists.get(i).equals("instructions:"))
			{
				for (int j = i + 1; j < lists.size(); j++)
				{
					Scanner scanner = new Scanner(lists.get(j).trim());
					String currentCode = scanner.next();
					if (labels.containsName(currentCode))
					{
						NVPair temp = labels.findByName(currentCode);
						temp.setValue(count);
					}

					else 
					{
						Instruction temp = new Instruction(lists.get(j));
						instructionStream.add(temp);
						count = count + 1;
					}
				}
			}
		}	
	}

	/**
	 * Fills in the correct operand value for all instructions (either a data 
	 * address or jump target address, depending on the instruction).
	 * We record the symbolic name for the operand (either a label for jump
	 * instructions or a variable name for the other instructions).
	 * For a jump instruction, we find the label in the symbol table for labels 
	 * and use the address previously stored.
	 * All the other instructions except halt, refer to a variable therefore
	 * we need the address for the variable. Find the index of the variable 
	 * in the data symbol table and add the size of the instruction list.
	 * For const_one, we add the length of the instruction list to the value 
	 * of const_one. 
	 */
	public void setOperandValues()
	{
		for (int i = 0; i < lists.size(); i++)
		{
			if (lists.get(i).equals("instructions:"))
			{	
				for (int j = 0; j < instructionStream.size(); j++)
				{
					Instruction temp = instructionStream.get(j);

					if (temp.requiresJumpTarget()) 
					{	
						String operandString = temp.getOperandString(); 
						NVPair label = labels.findByName(operandString); 
						int operandValue = label.getValue();
						temp.setOperand(operandValue);
					}


					else if (temp.requiresDataAddress())
					{
						String operandString = temp.getOperandString(); 
						NVPair codeCount = data.findByName(operandString);
						int index = data.indexOf(codeCount);
						
						if (operandString.equals(codeCount.getName())) {
							temp.setOperand(count + index); 
						}
						
						else
						{
							temp.setOperand(count);
						}
						if (temp.equals("halt")) 
						{
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Generates the machine code and data for this assembler's program,
	 * terminated by the string "-99999". Strings for instructions are produced
	 * by the Instruction method toString, and strings for data have the value 
	 * formatted as a four-digit signed integer, followed by a space, followed 
	 * by the variable name. 
	 * Using String.format to get the value to be represented by a four digit 
	 * string with the leading plus or minus sign. 
	 * @return
	 * list of strings containing the machine code and data for this assembler's 
	 * program
	 */
	public java.util.ArrayList<java.lang.String> writeCode()
	{
		ArrayList<String> codeData = new ArrayList<>();

		for (int i = 0; i < instructionStream.size(); i++)
		{
			codeData.add(instructionStream.get(i).toString());
		}
		for (int j = 0; j < data.size(); j++)
		{
			NVPair code = data.getByIndex(j);
			String codeName = code.getName();
			int codeValue = code.getValue();
			codeData.add(String.format("+%04d %s", codeValue, codeName));
		}
		codeData.add("-99999");

		return codeData;
	}
}
