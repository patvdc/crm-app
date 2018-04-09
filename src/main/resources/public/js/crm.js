window.addEventListener('load', () =>{
    let bb = document.getElementById('backbutton');
    if(bb){
    bb.addEventListener('click', () => {
            window.history.back();
        });
    }
})