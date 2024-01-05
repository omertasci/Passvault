
let dataTable = $('#entryTable').DataTable();

$( document ).ready(function() {
    	$('#entryTable_filter').css({"display": "flex","justify-content": "flex-end","align-items": "center"});
});


const entryModal = document.getElementById('entryDetailModal')

if (entryModal) {
  entryModal.addEventListener('show.bs.modal', event => {
    const button = event.relatedTarget
    const id = button.getAttribute('data-bs-entryid')

    if(id ==='new') return;

    let entryController = new EntryController();
    entryController.getEntryById(id, function(entryData){
            const modalTitle = entryModal.querySelector('.modal-title')
            const idInput = entryModal.querySelector('#id')
            const titleInput = entryModal.querySelector('#title-name')
            const usernameInput = entryModal.querySelector('#username-text')
            const passwordInput = entryModal.querySelector('#password-text')
            const weblinkInput = entryModal.querySelector('#weblink')
            const noteInput = entryModal.querySelector('#note')
            const createDateInput = entryModal.querySelector('#create-date')
            const updateDateInput = entryModal.querySelector('#update-date')

            idInput.value = entryData.id
            titleInput.value = entryData.title
            usernameInput.value = entryData.username
            passwordInput.value = entryData.password
            weblinkInput.value = entryData.weblink
            noteInput.value = entryData.note
            createDateInput.value = moment(entryData.createDate).format('LLL')
            updateDateInput.value = moment(entryData.updateDate).format('LLL')

            modalTitle.textContent = 'Edit ' + entryData.title +' entry'

        }, function(err){
            console.log(err);
        });
  })
}

function save_entry(){
    let entryDto = {
                id : entryModal.querySelector('#id').value,
                title : entryModal.querySelector('#title-name').value,
                username : entryModal.querySelector('#username-text').value,
                password : entryModal.querySelector('#password-text').value,
                weblink : entryModal.querySelector('#weblink').value,
                note : entryModal.querySelector('#note').value
    };

    let entryController = new EntryController();
    entryController.saveEntry(entryDto,
        function(data){
            alert('Entry saved');
        },
        function(err){
            alert(err);
        }
    );
}
