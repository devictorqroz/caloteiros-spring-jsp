
$(document).ready(function() {
    $('#deleteButton').click(function(event) {
        var result = confirm("Tem certeza de que deseja excluir este caloteiro?");
        if (!result) {
            event.preventDefault();
        }
    });
});
