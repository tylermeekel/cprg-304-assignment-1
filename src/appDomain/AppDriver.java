package appDomain;

public class AppDriver
{

	public static void main( String[] args )
	{
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





        // Example usage: java -jar Sort.jar -fshapes1.txt -t v -s b
        String fileName = "res/shapes1.txt";
        String sortBy = "";  // v for volume, h for height, a for base area
        String sortAlgorithm = "";  // b for bubble, s for selection, etc.
        
        // Parse the command line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-f")) {
                fileName = args[i].substring(2);
            } else if (args[i].startsWith("-t")) {
                sortBy = args[i].substring(2).toLowerCase();  // v, h, a
            } else if (args[i].startsWith("-s")) {
                sortAlgorithm = args[i].substring(2).toLowerCase();  // b, s, i, m, q, z (custom)
            }
        }

        // Load the shapes from the file (you'll need to implement this method)
        Shape[] shapes = loadShapesFromFile(fileName);

        // Choose the sorting criterion
        switch (sortBy) {
            case "h":  // Sort by height (using Comparable implementation)
                break;
            case "a":  // Sort by base area (use BaseAreaComparator)
                Arrays.sort(shapes, new BaseAreaComparator());
                break;
            case "v":  // Sort by volume (use VolumeComparator)
                Arrays.sort(shapes, new VolumeComparator());
                break;
        }

        // Choose the sorting algorithm
        switch (sortAlgorithm) {
            case "b":  // Bubble sort
                BubbleSort.sort(shapes);
                break;
            case "s":  // Selection sort
                SelectionSort.sort(shapes);
                break;
            case "i":  // Insertion sort
                InsertionSort.sort(shapes);
                break;
            case "m":  // Merge sort
                MergeSort.sort(shapes);
                break;
            case "q":  // Quick sort
                QuickSort.sort(shapes);
                break;
            case "z":  // Custom algorithm (e.g., Heap Sort)
                HeapSort.sort(shapes);
                break;
            default:
                System.out.println("Unknown sorting algorithm specified.");
                return;
        }

        // Benchmarking and displaying results (time taken, etc.)
        displayBenchmarkResults(shapes);
    }

    private static Shape[] loadShapesFromFile(String fileName) {
        // Implement the logic to load shapes from a file
        // For now, let's assume it's an array of Shape objects
        // e.g., return ShapeLoader.loadShapes(fileName);
        return new Shape[] {};
    }

    private static void displayBenchmarkResults(Shape[] shapes) {
        // Example: print first, last, and every 1000th shape
        System.out.println("First shape: " + shapes[0]);
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
        
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Every 1000th shape: " + shapes[i]);
        }
    }


	

}
