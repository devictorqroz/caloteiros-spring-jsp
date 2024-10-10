$(document).ready(function() {
	
	$('#labelDebt').maskMoney();
	$('#labelDate').inputmask("99/99/9999");
	
	
	$('#').validate({
		rules: {
			name: {
				required: true,
				maxlength: 50
			},
			email: {
				required: true,
				email: true
			},
			debt: {
				required: true,
				number: true
			}
		},
		messages: {
			name: {
				required: "Esse campo é obrigatório!",
				maxlength: "O campo nome não pode ter mais que 45 caracteres"
			},
			email: {
				required: "Esse campo é obrigatório!",
				email: "Este não é um email válido!"
			},
			debt: {
            	required: "Esse campo é obrigatório!",
                number: "Por favor, insira um número válido."
            }
		}
	});
	
	
	$('#').validate({
		rules: {
			name: {
				required: true,
				maxlength: 50
			},
			email: {
				required: true,
				email: true
			},
			debt: {
				required: true,
				number: true
			}
		},
		messages: {
			name: {
				required: "Esse campo é obrigatório!",
				maxlength: "O campo nome não pode ter mais que 45 caracteres"
			},
			email: {
				required: "Esse campo é obrigatório!",
				email: "Este não é um email válido!"
			},
			debt: {
            	required: "Esse campo é obrigatório!",
                number: "Por favor, insira um número válido."
            }
		}
	});
});

