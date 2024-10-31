$(document).ready(function() {
	
	$('#labelDebt').maskMoney();
	$('#labelDate').inputmask("99/99/9999");
	
	
	$('#formNewCaloteiro').validate({
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
				maxlength: "O campo nome não pode ter mais que 50 caracteres"
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
	
	
	$('#formUpdateCaloteiro').validate({
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
				maxlength: "O campo nome não pode ter mais que 50 caracteres"
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

	$('#formNewUser').validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            username: {
                required: "Esse campo é obrigatório!",
                minlength: "O campo nome não pode ter menos que 3 caracteres"
            },
            password: {
                required: "Esse campo é obrigatório!",
                minlength: "O campo nome não pode ter menos que 6 caracteres"
            }
        }
    });

	$('#formLogin').validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            username: {
                required: "Esse campo é obrigatório!",
                minlength: "O campo nome não pode ter menos que 3 caracteres"
            },
            password: {
                required: "Esse campo é obrigatório!",
                minlength: "O campo nome não pode ter menos que 6 caracteres"
            }
        }
    });
});

