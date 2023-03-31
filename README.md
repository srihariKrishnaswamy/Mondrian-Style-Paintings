README
Mondrian-Style Artificial Art Generator
This project is an implementation of an algorithmic art generator that creates images in the style of the 20th century Dutch abstract artist, Piet Mondrian.

The program starts with a blank canvas of a given width and height and repeatedly breaks the canvas into smaller and smaller regions until the regions are below a certain size. The program follows specific rules that attempt to emulate some of the techniques used by Mondrian. Once a region is below a certain size, it is filled in with a color chosen randomly from red, yellow, cyan, and white. This project uses a complex recursion algorithm to acheive this.

Program Behavior
The algorithm for generating images follows the following rules:

If the region being considered is at least one-fourth the height of the full canvas and at least one-fourth the width of the full canvas, split it into four smaller regions by choosing one vertical and one horizontal dividing line at random.
If the region being considered is at least one-fourth the height of the full canvas, split it into two smaller regions by choosing a horizontal dividing line at random.
If the region being considered is at least one-fourth the width of the full canvas, split it into two smaller regions by choosing a vertical dividing line at random.
If the region being considered is smaller than one-fourth the height of the full canvas and smaller than one-fourth the width of the full canvas, do not split the region.
Any time a region is split, the dividing line(s) are chosen at random to be within the bounds of the region. The algorithm ensures that dividing lines are chosen such that each resulting subregion is at least 10 pixels by 10 pixels.

Once a region is below a certain size, it is filled in with a color chosen randomly from red, yellow, cyan, and white. When filling a region, a one-pixel border around the edge is left uncolored to give the appearance of black lines separating the colored regions.

Running this program:
In order to run this program:
1. clone the repository by, in terminal, typing 'git clone ' and then the repo link
2. navigate to the src file in terminal 
3. in terminal, type 'javac App.java'
4. then type 'java App'
