CPRG 304 - Assignment 1 - Team Yunobo

This project demonstrates the use of various sorting algorithms to sort different geometric shapes by their base area and volume. The application allows users to select the preferred sorting method and criteria (base area or volume) in order to display the shapes in a sorted order.

Shape Details:
The shapes are represented as classes, with each shape containing a specific attribute such as base area, height, and volume. Each shape is stored as an object with these attributes and can be sorted on user input.

Data Formatting:
Each shape has specific characteristics stored in the following format:
- Cylinders: Represented by radius and height

- Prisms: Represented by base side length, number of sides, and height

- Pyramids: Represented by base area and height

Sorting Algorithms:
This project implements the following sorting algorithms

1. Bubble Sort: A simple algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

2. Insertion Sort: Builds the final sorted array one item at a time by repeatedly picking the next item and inserting it into the srted portion.

3. Selection Sort: Divides the list into sorted and unsorted parts, repeatedly selecting the smallest or largesy element from the unsorted part.

4. Merge Sort: A divide-and-conquer algorithim that splits the list into smaller sub-lists, sorts them recursively, and merges them back together.

Program Structure:
Inhertiance and Classes
This project make use of inheritance to create a hierarchy of geometric shapes. The shape class serves as a super-class and contains common attributes like base area and volume.

Each shape type is represented as a subclass, which inherits from the shape class. These subclasses implement their own constructors and override the toString() method to display their attributes in a format that is readable to users.

- Shape (super class): Defines common properties and mthods shared by all    shapes
  
- Cylinder (subclass): Represents a cylindrical shape

- Prism (subclass): Represents various prism shapes (e.g., pentagonal,       hexagonal)

- Pyramid (subclass): Represents a pyramid with a specific base and height

  Methods
  The following methods are implemented in the program:

  - Sorting: Users can choose from different sorting algorithms to order       shapes by either base area or volume
 
  - Comparison: Custom comparators are used to compare shapes based on         their base area or volume
 
  - Displaying Shapes: Once sorted, the shapes are displayed in a              formatted output
 
Sorting Algorithm Implementation:
Merge Sort:
Within this project, a merge sort has been implemented. This follows the   classic divide-and-conquer approach. The array is split into smaller arrays, sorted individually, and merged back together into a single sorted array.

Program Guidelines:

1. The program reads data from a file that contains information about         different shapes.

2. Users can choose a sorting algorithm and specify the criteria for          sorting base area or volume.

3. The sorted shapes are displayed in a user-friendly format.

4. The program is modular, with each shape having its own class, and sorting functionality is handled is a separate utility class.
