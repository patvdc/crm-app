
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

        if (contentHolder.style.display == "block" || contentHolder.style.display == "") {
             contentHolder.style.display = "none";
             button.innerHTML = "Show";
        } else {
             contentHolder.style.display = "block";
             button.innerHTML = "Hide";
        }
}

function deleteNote(noteIdForm) {
            let noteComment = document.getElementById('NoteComment' + noteIdForm);
            let noteId = document.getElementById('NoteId' + noteIdForm);

            let form = document.getElementById('notesForm');

            if(window.confirm("Are you sure?")){
                noteComment.value = "--remove this--";
                form.submit();
            }
        }