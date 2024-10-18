package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import shapes.Cone;
import shapes.Cylinder;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

public class AppDriver {

    public static void main(String[] args) {
        // Testing Code before Jar file is created
        String filePath = "shapes1.txt"; // Replace with the path to your file

        List<Shape> shapes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // First line contains the number of shapes
            String line = br.readLine();
            int numShapes = Integer.parseInt(line.trim()); // Read and parse the number of shapes

            // Read the subsequent lines, each representing a shape
            for (int i = 0; i < numShapes; i++) {
                line = br.readLine();
                if (line != null) {
                    // Split the line into shape type, height, and edge length/radius
                    String[] parts = line.split(" ");
                    String shapeType = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double edgeLengthOrRadius = Double.parseDouble(parts[2]);

                    // Switch block to instantiate different shape types
                    switch (shapeType.toLowerCase()) {
                        case "cone":
                            shapes.add(new Cone(height, edgeLengthOrRadius));
                            break;
                        case "cylinder":
                            shapes.add(new Cylinder(height, edgeLengthOrRadius));
                            break;
                        case "octagonalprism":
                            // Assuming OctagonalPrism is another shape you have, if not, adjust
                            shapes.add(new Cylinder(height, edgeLengthOrRadius)); // Placeholder
                            break;
                        case "pentagonalprism":
                            shapes.add(new PentagonalPrism(height, edgeLengthOrRadius));
                            break;
                        case "pyramid":
                            shapes.add(new Pyramid(height, edgeLengthOrRadius));
                            break;
                        case "squareprism":
                            shapes.add(new SquarePrism(height, edgeLengthOrRadius));
                            break;
                        case "triangularprism":
                            shapes.add(new TriangularPrism(height, edgeLengthOrRadius));
                            break;
                        default:
                            System.out.println("Unknown shape type: " + shapeType);
                    }
                }
            }

            // Print all shapes after reading them
            for (Shape shape : shapes) {
                System.out.println(shape);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Handle file reading errors
        }
    }
}





		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

        // Example usage: java -jar Sort.jar -fshapes1.txt -t v -sb
    //     String fileName = "";
    //     String sortBy = "";  // v for volume, h for height, a for base area
    //     String sortAlgorithm = "";  // b for bubble, s for selection, etc.
        
    //     // Parse the command line arguments
    //     for (int i = 0; i < args.length; i++) {
    //         if (args[i].startsWith("-f")) {
    //             fileName = args[i].substring(2);
    //         } else if (args[i].startsWith("-t")) {
    //             sortBy = args[i].substring(2).toLowerCase();  // v, h, a
    //         } else if (args[i].startsWith("-s")) {
    //             sortAlgorithm = args[i].substring(2).toLowerCase();  // b, s, i, m, q, z (custom)
    //         }
    //     }

    //     // Load the shapes from the file (you'll need to implement this method)
    //     Shape[] shapes = loadShapesFromFile(fileName);

        // // Choose the sorting criterion
        // switch (sortBy) {
        //     case "h":  // Sort by height (using Comparable implementation)
        //         break;
        //     case "a":  // Sort by base area (use BaseAreaComparator)
        //         Arrays.sort(shapes, new BaseAreaComparator());
        //         break;
        //     case "v":  // Sort by volume (use VolumeComparator)
        //         Arrays.sort(shapes, new VolumeComparator());
        //         break;
        // }

    //     // Choose the sorting algorithm
        // switch (sortAlgorithm) {
        //     case "b":  // Bubble sort
        //         Sort.bubbleSort(shapes);
        //         break;
        //     case "s":  // Selection sort
		// 		Sort.selectionSort(shapes);
        //         break;
        //     case "i":  // Insertion sort
		// 		Sort.insertionSort(shapes);
        //         break;
        //     case "m":  // Merge sort
		// 		Sort.mergeSort(shapes);
        //         break;
        //     case "q":  // Quick sort
		// 		Sort.quickSort(shapes);
        //         break;
        //     case "z":  // Custom algorithm
		// 		Sort.bogoSort(shapes);
        //         break;
        //     default:
        //         System.out.println("Unknown sorting algorithm specified.");
        //         return;
        // }

    //     // Benchmarking and displaying results (time taken, etc.)
    //     displayBenchmarkResults(shapes);
    // }

    // private static Shape[] loadShapesFromFile(String fileName) {
    //     // Implement the logic to load shapes from a file
    //     // For now, let's assume it's an array of Shape objects
    //     // e.g., return ShapeLoader.loadShapes(fileName);
    //     return new Shape[] {};
    // }

    // private static void displayBenchmarkResults(Shape[] shapes) {
    //     // Example: print first, last, and every 1000th shape
    //     System.out.println("First shape: " + shapes[0]);
    //     System.out.println("Last shape: " + shapes[shapes.length - 1]);
        
    //     for (int i = 1000; i < shapes.length; i += 1000) {
    //         System.out.println("Every 1000th shape: " + shapes[i]);
    //     }
    // }



