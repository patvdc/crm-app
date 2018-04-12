
window.addEventListener('load', () =>{
    let bb = document.getElementById('backbutton');
    if(bb){
    bb.addEventListener('click', () => {
            window.history.back();
        });
    }

    let changeViewAddress = document.getElementById("changeViewAddress");
    if(changeViewAddress){
    changeViewAddress.addEventListener("click", function(){showHide(changeViewAddress, "addresses", "Addresses")});
        }
    let changeViewNotes = document.getElementById("changeViewNotes");
    if(changeViewNotes){
    changeViewNotes.addEventListener("click", function(){showHide(changeViewNotes, "notesForm", "Notes")});
    }
});

function showHide(button, content, text) {
        let contentHolder = document.getElementById(content);
        if (contentHolder.style.display === "block") {
             contentHolder.style.display = "none";
             button.innerHTML = "Show " + text;
        } else {
             contentHolder.style.display = "block";
             button.innerHTML = "Hide " + text;
        }
}