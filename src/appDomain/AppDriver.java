package appDomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        
            if (argsInput[1].startsWith("-t")) {
                char type = argsInput[1].charAt(2);

                switch (type) {
                    case 'v':
                        Arrays.sort(shapes, new VolumeComparator());
                        for (Shape shape : shapes) {
                            System.out.println(shape);
                        }    
                        break;
                    case 'h':
                        break;
                    case 'a':
                        Arrays.sort(shapes, new BaseAreaComparator());
                        break;
                    default:
                        System.out.println("Invalid type option. Defaulting to volume.");
                        Arrays.sort(shapes, new VolumeComparator());
                        break;
                }
            }
            if (argsInput.length > 2 && argsInput[2].startsWith("-s") && argsInput[1].charAt(2) == 'h') {
                char sortType = argsInput[2].charAt(2);
                long startTime, endTime;
                
                switch (sortType) {
                    case 'b':
                        startTime = System.currentTimeMillis();
                        Sort.bubbleSort(shapes);
                        endTime = System.currentTimeMillis();
                        break;
                    case 's':
                        startTime = System.currentTimeMillis();
                        Sort.selectionSort(shapes);
                        endTime = System.currentTimeMillis();
                        break;
                    case 'i':
                        startTime = System.currentTimeMillis();
                        Sort.insertionSort(shapes);
                        endTime = System.currentTimeMillis();
                        break;
                    case 'm':
                        startTime = System.currentTimeMillis();
                        Sort.mergeSort(shapes);
                        endTime = System.currentTimeMillis();
                        break;
                    case 'q':
                        startTime = System.currentTimeMillis();
                        Sort.quickSort(shapes, 0, shapes.length);
                        endTime = System.currentTimeMillis();
                        break;
                    case 'z':
                        startTime = System.currentTimeMillis();
                        Sort.bogoSort(shapes);
                        endTime = System.currentTimeMillis();
                        break;
                    default:
                        System.out.println("Invalid sorting algorithm. Defaulting to bubble sort.");
                        startTime = System.currentTimeMillis();
                        Sort.bubbleSort(shapes);
                        endTime = System.currentTimeMillis();
                }
                if(argsInput.length > 2 && argsInput[2].startsWith("-s") && argsInput[1].charAt(2) == 'h'){
                    System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");
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
}
