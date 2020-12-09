package mini2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CS227Comp {
	
	/**
	 * Opcode for the read instruction.
	 */
	public static final int READ      = 10;

	/**
	 * Opcode for the write instruction.
	 */
	public static final int WRITE     = 20;

	/**
	 * Opcode for the load instruction.
	 */
	public static final int LOAD      = 30;

	/**
	 * Opcode for the store instruction.
	 */
	public static final int STORE     = 40;

	/**
	 * Opcode for the add instruction.
	 */
	public static final int ADD       = 50;

	/**
	 * Opcode for the sub instruction.
	 */  
	public static final int SUB       = 51;

	/**
	 * Opcode for the div instruction.
	 */  
	public static final int DIV       = 52;

	/**
	 * Opcode for the mod instruction.
	 */
	public static final int MOD       = 53;

	/**
	 * Opcode for the mul instruction.
	 */
	public static final int MUL       = 54;

	/**
	 * Opcode for the jump instruction.
	 */
	public static final int JUMP      = 60;

	/**
	 * Opcode for the jumpn (jump if negative) instruction.
	 */
	public static final int JUMPN     = 61;

	/**
	 * Opcode for the jumpz (jump if zero) instruction.
	 */
	public static final int JUMPZ     = 63;

	/**
	 * Opcode for the halt instruction.
	 */
	public static final int HALT      = 80;
	
	
	private int[] memoryImage;
	private int currentNum;
	private int count;
	private int opcode = 0;
	private int operand = 0;
	private boolean isHalted;
	private int accumulator;
	private int i = 1;

	
	/**
	 * Constructs a machine with the given number of words of memory, all words
	 * zero, all registers zero, in a halted state.
	 */
	public CS227Comp(int memorySize)
	{
		memoryImage = new int[memorySize];
		for (int i = 0; i < memoryImage.length; i++)
		{
			memoryImage[i] = 0;
		}
		isHalted = true;
	}

	/**
	 * Constructs a machine with the given initial values in the instruction
	 * counter and accumulator, and the given memory contents.  The memory
	 * size will be that of the given array.  Immediately crashes the machine
	 * if the given memory contains any invalid instructions, as
	 * specified in loadMemoryImage.
	 * @param initialIC
	 * @param initialAC
	 * @param memoryImage
	 */
	public CS227Comp(int initialIC, int initialAC, int[] memoryImage)
	{
		count = initialIC;
		accumulator = initialAC;
		this.memoryImage = memoryImage;
		currentNum = memoryImage[0];
	}

	/**
	 * Returns the current value in the accumulator.
	 * @return
	 *   current value in the accumulator
	 */
	public int getAC()
	{
		return accumulator;
	}

	/**
	 * Returns the current value of the instruction counter.
	 * @return
	 *   current value of the instruction counter
	 */
	public int getIC()
	{
		return count;
	}

	/**
	 * Returns the contents of the instruction register (most recently executed
	 * instruction)
	 * @return
	 *   contents of the instruction register
	 */
	public int getIR()
	{
		return currentNum;
	}

	/**
	 * Returns the opcode for the most recently executed instruction
	 * (instruction register divided by 100).
	 * @return
	 *   opcode for the most recently executed instruction
	 */
	public int getOpcode()
	{ 
		return opcode;
	}

	/**
	 * Returns the operand for the most recently executed instruction
	 * (instruction register modulo 100).
	 * @return
	 *   operand for the most recently executed instruction
	 */
	public int getOperand()
	{
		return operand;
	}

	/**
	 * Returns true if the machine is in a halted state, false otherwise.
	 * @return
	 *   true if the machine is in a halted state, false otherwise
	 */
	public boolean isHalted()
	{
		return isHalted;
	}

	/**
	 * Returns the contents of the memory cell at the given address.
	 * @param address
	 *   memory address
	 * @return
	 *   contents of memory cell at the given address
	 */
	public int peekMemory(int address)
	{
		return memoryImage[address];
	}

	/**
	 * Returns the number of words of memory this machine has.
	 * @return
	 *   the number of words of memory
	 */
	public int getMemorySize()
	{
		return memoryImage.length;
	}

	/**
	 * Executes one instruction at a time, over and over, as long as the
	 * machine is not halted.
	 */
	public void runProgram()
	{
		while(!isHalted)
		{
			nextInstruction();
		}
	}

	/**
	 * Displays complete machine state.  This one is done for you.  Observe the
	 * conversions that are used to print the values, as you'll need them
	 * elsewhere if you want a uniform look to your output.
	 */
	public void dumpCore()
	{
		System.out.printf("REGISTERS:\n");
		System.out.printf("%-20s %+05d\n", "accumulator", getAC());
		System.out.printf("%-20s    %02d\n", "instruction counter",
				getIC());
		System.out.printf("%-20s %+05d\n", "instruction register",
				getIR());
		System.out.printf("%-20s    %02d\n", "operation code", getIR() / 100);
		System.out.printf("%-20s    %02d\n", "operand", getIR() % 100);
		System.out.printf("\nMEMORY:\n  ");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%6d", i);
		}
		int row = 0;
		for (int i = 0; i < getMemorySize(); i++)
		{
			if (i % 10 == 0)
			{
				row += 1;
				System.out.printf("\n%2d ", row * 10);
			}
			System.out.printf("%+05d ", peekMemory(i));        
		}
		System.out.println();
	}


	/**
	 * Loads the given values into the machine's memory.  If the length of the
	 * given array is smaller than this machine's memory size, the remaining
	 * cells are filled with zeros; if larger, extra values are ignored.  If
	 * any value is encountered in the given array that is not a valid
	 * instruction, the machine crashes at that point with message "*** Invalid
	 * input ***".  The machine's memory size is not modified.  If no invalid
	 * instructions are encountered, the machine will be in a non-halted state.
	 * @param image
	 *   memory image to load
	 */
	public void loadMemoryImage(int[] image)
	{		
		if (image.length < memoryImage.length)
		{
			for (int i = 0; i < image.length; i++)
			{
				memoryImage[i] = image[i];
			}
			for (int i = image.length; i < memoryImage.length; i++)
			{
				memoryImage[i] = 0;
			}
		}
		else if (image.length > memoryImage.length)
		{
			for (int i = 0; i < memoryImage.length - image.length; i++)
			{
				memoryImage[i] = image[i];
			}
		}
	}

	/**
	 * Reads instructions from the terminal, one per line, until the sentinel
	 * value (-99999) is read.  Instructions are decimal integers in the range
	 * [-9999,9999].  Any invalid input should immediately crash the machine
	 * with error message "*** Invalid input ***".  Each instruction should be
	 * prompted for with the zero-padded, two digit sequential instruction
	 * number followed by a question mark.  The instruction or sentinel should
	 * then be echoed as a four digit (or five, for the sentinel), signed,
	 * zero-padded decimal integer.  After successfully loading, display the
	 * message "*** Program Loaded ***" and move to a running state.
	 */
	public void loadProgramFromConsole()
	{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt() && scan.nextInt() != -99999)
		{
			
		}
		
	}

	/**
	 * Reads instructions from the given file.  Instructions are then loaded
	 * into memory according to the specification for loadMemoryImage.
	 * @param filename
	 *   file from which to read instructions
	 */
	public void loadProgramFromFile(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		memoryImage[0] = scan.nextInt();
		
		while (scan.hasNextInt())
		{
			memoryImage[i] = scan.nextInt();
			i += 1;
		}
		
	}

	/**
	 * Loads the next instruction from memory, parses it for the opcode and
	 * operand, and executes the instruction. The opcode is the high-order two
	 * digits of the instruction; the operand is the low-order two digits.
	 * Except in case of a jump, the instruction counter is incremented by one
	 * following execution of the instruction.
	 * <p>
	 * Invalid opcodes crash the machine.
	 * <p>
	 * Descriptions of all instructions follow:
	 *
	 * <ul>
	 * <li>READ:
	 * Executes the read instruction.  Reads a decimal word from the terminal
	 * into the address referenced by operand and updates the instruction
	 * counter.  Valid words are in the range [-9999,9999].  Out of range words
	 * are truncated on the right until within range before being stored; the
	 * truncated portion is discarded.  For example, -723471 will be truncated
	 * to -7234.
	 *
	 * <li>WRITE:
	 * Displays the value stored in memory at the address referenced by the
	 * operand as a signed, four digit, zero padded decimal integer and updates
	 * the instruction counter.
	 *
	 * <li>LOAD:
	 * Loads the value stored in memory at the address referenced by operand
	 * into the accumulator and updates the instruction counter.
	 *
	 * <li>STORE:
	 * Stores the value in the accumulator into memory at the address
	 * referenced by the operand and updates the instruction counter.
	 *
	 * <li>ADD:
	 * Adds the value stored in memory at the address referenced by operand to
	 * the accumulator, accounting for overflow, and updates the instruction
	 * counter.
	 *
	 * <li>SUB:
	 * Subtracts the value stored in memory at the address referenced by operand
	 * from the accumulator, accounting for overflow, and updates the
	 * instruction counter.
	 *
	 * <li>DIV:
	 * Divides the accumulator by the value stored in memory at the address
	 * referenced by operand, accounting for overflow, and updates the
	 * instruction counter.  All division is integer division.  Division by
	 * zero crashes the machine.
	 *
	 * <li>MOD:
	 * Calculates the remainder when dividing the accumulator by the value
	 * stored in memory at the address referenced by operand, accounting for
	 * overflow, stores the result in the accumulator, and updates the 
	 * instruction counter.  All division is integer division.  Division 
	 * by zero crashes the machine.
	 *
	 * <li>MUL:
	 * Multiplies the accumulator by the value stored in memory at the address 
	 * referenced by operand, accounting for overflow, and updates the
	 * instruction counter.
	 *
	 * <li>JUMP:
	 * Changes the instruction counter to operand.
	 *
	 * <li>JUMPN:
	 * If the accumulator is negative, changes the instruction counter to
	 * operand, otherwise updates the instruction counter normally.
	 *
	 * <li>JUMPZ:
	 * If the accumulator is zero, changes the instruction counter to operand,
	 * otherwise updates the instruction counter normally.
	 *
	 * <li>HALT:
	 * Displays the message "*** Program terminated normally ***", halts the
	 * machine, and dumps core.
	 * </ul>
	 * Arithmetic overflow occurs when the accumulator acquires a value outside
	 * of the range [-9999,9999].  It is handled by truncating the value of the
	 * accumulator to the low order four digits.
	 * <p>
	 * Instruction counter overflow occurs when when the value of the
	 * instruction counter matches or exceeds the memory size.  It is handled
	 * by setting the instruction counter to zero.
	 * <p>
	 * All crashes dump core.
	 */
	public void nextInstruction()
	{
		isHalted = false;
		if (count < memoryImage.length - 1)
		{

			if (count == 0)
			{
				currentNum = memoryImage[0];
			}
			else if(count >= 1)
			{
				currentNum = memoryImage[count];
			}

			opcode = currentNum / 100;
			operand = currentNum % 100;

			if (opcode == 10)
			{
				count = count + 1;

			}

			else if (opcode == 20)
			{
				count = count + 1;

			}

			else if (opcode == 30)
			{
				accumulator = memoryImage[operand];
				count = count + 1;
			}

			else if (opcode == 40)
			{
				count = count + 1;
				memoryImage[operand] = accumulator;
			}

			else if (opcode == 50)
			{
				count = count + 1;
				accumulator = accumulator + memoryImage[operand];
			}

			else if (opcode == 51)
			{
				count = count + 1;
				accumulator = accumulator - memoryImage[operand];
			}

			else if (opcode == 52)
			{
				count = count + 1;
				if (memoryImage[operand] == 0)
				{
					dumpCore();
					isHalted = true;
				}
				else
				{
					accumulator = accumulator / memoryImage[operand];
				}
			}

			else if (opcode == 53)
			{
				count = count + 1;
				accumulator = accumulator % memoryImage[operand];
			}

			else if (opcode == 54)
			{
				count = count + 1;
				accumulator = accumulator * memoryImage[operand];
			}

			else if (opcode == 60)
			{
				count = operand;
			}

			else if (opcode == 61)
			{
				if (accumulator < 0)
				{
					count = operand;
				}
				else 
				{
					count = count + 1;
				}

			}

			else if (opcode == 63)
			{
				if (accumulator == 0)
				{
					count = operand;
				}
				else 
				{
					count = count + 1;
				}

			}

			else if (opcode == 80)
			{
				count = count + 1;
				System.out.println("*** Program terminated normally ***");
				isHalted = true;
				dumpCore();
			}
			else 
			{
				dumpCore();
				isHalted = true;
			}


			if (accumulator > 9999 || accumulator < -9999)
			{
				accumulator = accumulator % 10000;
			}
		}
		
		else if (count >= memoryImage.length - 1)
		{
			count = 0;
		}
		
	}
}