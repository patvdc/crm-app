window.addEventListener('load', () =>{
    let bb = document.getElementById('backbutton');
    if(bb){
    bb.addEventListener('click', () => {
            window.history.back();
        });
    }

    let changeView = document.getElementById("changeView");
    changeView.addEventListener("click", function() {
        let addresses = document.getElementById("addresses");
        if (addresses.style.display === "block") {
             addresses.style.display = "none";
        } else {
             addresses.style.display = "block";
        }
        });
});