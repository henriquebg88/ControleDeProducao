var requiredItems   = document.querySelectorAll(':required');
var submitButton    = document.querySelector('[type=submit]');


 submitButton.disabled = true;

 requiredItems.forEach(item => {
     addEventListener('input', checkInputs);
 });

function checkInputs() {

    var requiredItems   = document.querySelectorAll(':required');

    for (let i = 0; i < requiredItems.length; i++) {
        const item = requiredItems[i];

        if(item.value.trim() == "") {
            submitButton.disabled = true;
            return;
        }
        
        submitButton.disabled = false;
    }



}