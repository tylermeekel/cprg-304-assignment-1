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
 
    
    public static void main(String[] args)  {      

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
            scanner.close();
            return; 
        }
        else {

            Shape[] shapes = loadShapesFromFile(filePath); 


            if (argsInput[1].startsWith("-t")) {
                    char type = argsInput[1].charAt(2);
                    switch (type) {
                        case 'v':
                            Arrays.sort(shapes, new VolumeComparator());
                            break;
                        case 'h':
                            break;
                        case 'a':
                            Arrays.sort(shapes, new BaseAreaComparator());
                            break;
                        default:
                            System.out.println("Invalid type option. Defaulting to volume.");
                            Arrays.sort(shapes, new VolumeComparator());
                    }
            }
            if (argsInput[2].startsWith("-s") && argsInput[1].charAt(2) == 'h' && argsInput.length > 2) {
                char sortType = argsInput[2].charAt(2);
                switch (sortType) {
                    case 'b':
                        Sort.bubbleSort(shapes);
                        break;
                    case 's':
                        Sort.selectionSort(shapes);
                        break;
                    case 'i':
                        Sort.insertionSort(shapes);
                        break;
                    case 'm':
                        Sort.mergeSort(shapes);
                        break;
                    case 'q':
                        Sort.quickSort(shapes, 0, shapes.length);
                        break;
                    case 'z':
                        Sort.bogoSort(shapes);
                        break;
                    default:
                        System.out.println("Invalid sorting algorithm. Defaulting to bubble sort.");
                        Sort.bubbleSort(shapes);
                    }
                }
                displayBenchmarkResults(shapes);
                for (Shape shape : shapes) {
                    System.out.println(shape);
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
                    // Split the line into shape type, height, and edge length/radius
                    String[] parts = line.split(" ");
                    String shapeType = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double edgeLengthOrRadius = Double.parseDouble(parts[2]);
 
                    // Switch block to instantiate different shape types
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
 
    private static void displayBenchmarkResults(Shape[] shapes) {
        System.out.println("First shape: " + shapes[0]);
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
        
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Every 1000th shape: " + shapes[i]);
        }
    }
 
}
 

