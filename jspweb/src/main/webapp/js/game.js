///DRY code, shoutout to Venkat Subramaniam
let start = document.querySelector('.logo');
let ex = 16;
function swing(element) {

    function update(time) {
        
        const x = Math.sin(time / 1231) * ex;
        const y = Math.sin(time / 1458) * ex;

        element.style.transform = [
            `rotateX(${x}deg)`,
            `rotateY(${y}deg)`
        ].join(' ');

        requestAnimationFrame(update);
    }
    update(0); //love your nested functions
}

swing(start);


let start_button = document.querySelector('.start');
let og_color = start_button.style.color;
let inter = 0;

start_button.addEventListener('mouseover', (e) => {  
 inter = setInterval(()=>{  
    start_button.style.color = '#'+Math.floor(Math.random()*16777215).toString(16); 
  }, 400); 
  
});


start_button.addEventListener('mouseout', (e) => {
  
  ex = 10;
  clearInterval(inter);
  start_button.style.color = og_color; 
  
});