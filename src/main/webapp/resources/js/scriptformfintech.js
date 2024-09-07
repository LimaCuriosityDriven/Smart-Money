document.addEventListener('DOMContentLoaded', function() {
    var formDespesa = document.getElementById('formDespesa');
    var statusCheckbox = document.getElementsByName('statusdespesa')[0];

    formDespesa.addEventListener('submit', function() {
        // Se a caixa de seleção não estiver marcada, defina o valor como 0
        if (!statusCheckbox.checked) {
            statusCheckbox.value = 0;
        }
    });
});