
window.addEventListener('load', () =>{
    let bb = document.getElementById('backbutton');
    if(bb){
    bb.addEventListener('click', () => {
            window.history.back();
        });
    }

});

function showHide(button, content) {
        let contentHolder = document.getElementById(content);
                console.log(contentHolder.style.display);

        if (contentHolder.style.display == "block" || contentHolder.style.display == "") {
             contentHolder.style.display = "none";
             button.innerHTML = "Show";
        } else {
             contentHolder.style.display = "block";
             button.innerHTML = "Hide";
        }
}