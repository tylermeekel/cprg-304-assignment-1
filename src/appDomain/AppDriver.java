package appDomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import shapes.*;
import utilities.*;

public class AppDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input in the following format:");
        System.out.println("Example: -fshapes1.txt -th -sb");
        System.out.println("Input: ");
        String userInput = scanner.nextLine().toLowerCase();

        String[] argsInput = userInput.split(" ");
        scanner.close();

        String filePath = argsInput[0].substring(2);
        File file = new File(filePath);

        if (!file.exists() || file.isDirectory()) {
            System.out.println("Invalid file name or file does not exist.");
            return;
        } else {
            Shape[] shapes = loadShapesFromFile(filePath);

            Comparator<Shape> comparator = null;
            String printCriteria = "all"; // Default to print all attributes

            // Select the comparator based on the user input for type (-tv for volume, -th for height, -ta for base area)
            if (argsInput[1].startsWith("-t")) {
                char type = argsInput[1].charAt(2);

                switch (type) {
                    case 'v':
                        comparator = new VolumeComparator();
                        printCriteria = "volume"; // Set print criteria to volume
                        break;
                    case 'h':
                        comparator = new HeightComparator();
                        printCriteria = "height"; // Set print criteria to height
                        break;
                    case 'a':
                        comparator = new BaseAreaComparator();
                        printCriteria = "baseArea"; // Set print criteria to base area
                        break;
                    default:
                        System.out.println("Invalid type option. Defaulting to volume.");
                        comparator = new VolumeComparator();
                        printCriteria = "volume"; // Default to volume
                        break;
                }
            }

            if (comparator == null) {
                System.out.println("No valid comparator found.");
                return;
            }

            // Select the sorting algorithm based on the user input for sorting method (-sb for bubble sort, -si for insertion sort, etc.)
            if (argsInput.length > 2 && argsInput[2].startsWith("-s")) {
                char sortType = argsInput[2].charAt(2);
                long startTime, endTime;

                switch (sortType) {
                    case 'b': // Bubble Sort
                        startTime = System.currentTimeMillis();
                        Sort.bubbleSort(shapes, comparator); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Bubble Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    case 's': // Selection Sort
                        startTime = System.currentTimeMillis();
                        Sort.selectionSort(shapes, comparator); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Selection Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    case 'i': // Insertion Sort
                        startTime = System.currentTimeMillis();
                        Sort.insertionSort(shapes, comparator); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Insertion Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    case 'm': // Merge Sort
                        startTime = System.currentTimeMillis();
                        Sort.mergeSort(shapes, comparator); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Merge Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    case 'q': // Quick Sort
                        startTime = System.currentTimeMillis();
                        Sort.quickSort(shapes, 0, shapes.length - 1, comparator); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Quick Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    case 'z': // Bogo Sort
                        startTime = System.currentTimeMillis();
                        Sort.bogoSort(shapes); // Sort shapes by selected criteria
                        endTime = System.currentTimeMillis();
                        System.out.println("Sorted using Bogo Sort by " + getSortCriteria(argsInput[1]));
                        break;
                    default:
                        System.out.println("Invalid sorting algorithm. Defaulting to Bubble Sort.");
                        startTime = System.currentTimeMillis();
                        Sort.bubbleSort(shapes, comparator); // Default to Bubble Sort
                        endTime = System.currentTimeMillis();
                }

                System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");

                // Ensure sorted shapes are printed
                System.out.println("Sorted Shapes:");
                for (Shape shape : shapes) {
                    System.out.println(shape.toString(printCriteria)); // Print sorted shapes based on the print criteria
                }
            }
        }
    }

    public static Shape[] loadShapesFromFile(String filePath) {
        Shape[] shapes = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int numShapes = Integer.parseInt(line.trim());
            shapes = new Shape[numShapes];

            for (int i = 0; i < numShapes; i++) {
                line = br.readLine();
                if (line != null) {
                    String[] parts = line.split(" ");
                    String shapeType = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double edgeLengthOrRadius = Double.parseDouble(parts[2]);

                    switch (shapeType.toLowerCase()) {
                        case "cone":
                            shapes[i] = new Cone(height, edgeLengthOrRadius);
                            break;
                        case "cylinder":
                            shapes[i] = new Cylinder(height, edgeLengthOrRadius);
                            break;
                        case "octagonalprism":
                            shapes[i] = new OctagonalPrism(height, edgeLengthOrRadius);
                            break;
                        case "pentagonalprism":
                            shapes[i] = new PentagonalPrism(height, edgeLengthOrRadius);
                            break;
                        case "pyramid":
                            shapes[i] = new Pyramid(height, edgeLengthOrRadius);
                            break;
                        case "triangularprism":
                            shapes[i] = new TriangularPrism(height, edgeLengthOrRadius);
                            break;
                        case "squareprism":
                            shapes[i] = new SquarePrism(height, edgeLengthOrRadius);
                            break;
                        default:
                            System.out.println("Unknown shape type: " + shapeType);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return shapes;
    }

    private static String getSortCriteria(String type) {
        switch (type.charAt(2)) {
            case 'v': return "Volume";
            case 'h': return "Height";
            case 'a': return "Base Area";
            default: return "Unknown";
        }
    }
}

