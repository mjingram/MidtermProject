const canvas = document.getElementById("canvas1");
const ctz = canvas.getContext('2d');
ctz.canvas.width = window.innerWidth;
ctz.canvas.height = window.innerHeight;

let particleArray;

//create constructor
function Particle(x, y, directionX, directionY, size, color){
  this.x = x;
  this.y = y;
  this.directionX = directionX;
  this.directionY = directionY;
  this.size = size;
  this.color = color;

}

//add draw method to particle prototype
Particle.prototype.draw = function(){
  ctz.beginPath();
  ctz.arc(this.x, this.y, this.size, 0, Math.PI*2, false);
  ctz.fillStyle = this.color;
  ctz.strokeStyle = 'black';
  ctz.opacity = 0.5;
  ctz.fill();
}

Particle.prototype.update = function(){
  if(this.x + this.size > canvas.width || this.x-this.size <0){
    this.directionX = -this.directionX;
  }
  if(this.y + this.size > canvas.height || this.y-this.size <0){
    this.directionY = -this.directionY;
  }
  // this.x += this.directionX;
  this.y += this.directionY;
  this.draw();
}

function init(){
  particleArray = [];
  for(let i=0; i<1000; i++){
    let size = Math.random() * 8;
    let x = Math.random() * (innerWidth - size *2);
    let y = Math.random() * (innerHeight - size * 2);
    let directionX = (Math.random() *.4) -.2;
    let directionY = (Math.random() *.4) -.2;
    let color = 'rgba(235, 213, 175, 1)';
    particleArray.push(new Particle(x, y, directionX, directionY, size, color));
  }
}
//animation loop
function animate(){
  requestAnimationFrame(animate);
  ctz.clearRect(0,0,  innerWidth, innerHeight);

  for(let i =0; i<particleArray.length; i++){
    particleArray[i].update();
  }
}

init();
animate();

window.addEventListener('resize',
function(){
  canvas.width = innerWidth;
  canvas.height = innerHeight;
  init();
})
