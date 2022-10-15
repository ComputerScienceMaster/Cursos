let w = 50;
let cols = 0;
let rows = 0;
let grid = [];

let points1 = [
  new Cell(0, 1, "yellow"),
  new Cell(0, 2, "yellow"),
  new Cell(0, 3, "yellow"),
];

function setup() {
  createCanvas(500, 500);
  frameRate(2);
  cols = width / w;
  rows = height / w;
  initialize();
  console.log(grid);
  insertData(points1);
}

function draw() {
  background(70);
  showCells();
}

function findCell(x, y) {
  for (i = 0; i < grid.length; i++) {
    if (grid[i].x == x && grid[i].y == y) {
      return i;
    }
  }
}

function insertData(points) {
  for (let i = 0; i < points.length; i++) {
    let cell = findCell(points[i].x, points[i].y);
    grid[cell] = points[i];
  }
}

function showCells() {
  for (let x = 0; x < grid.length; x++) {
    grid[x].show();
  }
}

function initialize() {
  for (let x = 0; x < rows; x++) {
    for (let y = 0; y < cols; y++) {
      grid.push(new Cell(x, y));
    }
  }
}

function Cell(x, y, highlight = "") {
  this.x = x;
  this.y = y;
  this.highlight = highlight;

  this.show = function () {
    let x = this.x * w;
    let y = this.y * w;
    rect(x, y, w, w);
    console.log(x, y, w, w);
    if (this.highlight == "") {
      fill(255, 255, 255);
    } else if (this.highlight == "yellow") {
      fill(255, 204, 0);
    }
  };
}
