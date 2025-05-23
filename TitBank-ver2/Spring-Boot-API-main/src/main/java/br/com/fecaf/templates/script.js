// Login
document.getElementById('loginForm')?.addEventListener('submit', async function(e) {
    e.preventDefault();
    const cpf = document.getElementById('cpf').value;
    const senha = document.getElementById('senha_login').value;
    if (!cpf || !senha) {
        alert('Por favor, preencha todos os campos!');
        return;
    }
    try {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ cpf, senha })
        });
        const data = await response.json();
        if (response.ok) {
            localStorage.setItem('token', data.token);
            window.location.href = 'home.html';
        } else {
            alert('Login falhou: ' + (data.message || response.statusText));
        }
    } catch (error) {
        alert('Erro ao fazer login: ' + error.message);
    }
});

// Cadastro
document.getElementById('signupForm')?.addEventListener('submit', async function(e) {
    e.preventDefault();
    const nome = document.getElementById('nome-usuario').value;
    const cpf = document.getElementById('cpf-cadastro').value;
    const senha = document.getElementById('senha').value;

        if (!nome || !cpf || !senha) {
                alert('Por favor, preencha todos os campos!');
                return;
            }
            try {
                const response = await fetch('http://localhost:8080/clientes', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ cpf, nome, senha })
                });
                const clientes = await response.json();
                if (response.ok) {
                    alert('Usuário cadastrado com sucesso!');
                    window.location.href = 'login.html';
                } else {
                    alert('Erro ao cadastrar: ' + (clientes.message || response.statusText));
                }
            } catch (error) {
                alert('Erro ao cadastrar: ' + error.message);
            }
});


window.addEventListener('load', async function() {
    if (window.location.pathname.includes('contas.html')) {
        try {
            const token = localStorage.getItem('token');
            const response = await fetch('http://localhost:8080/contas', {
                headers: { 'Authorization': 'Bearer ' + token }
            });
            const contas = await response.json();
            const contasList = document.getElementById('contasList');
            contasList.innerHTML = contas.map(c => `<div>${c.numero} - Saldo: R$ ${c.saldo}</div>`).join('');
        } catch (error) {
            console.error('Erro ao buscar contas:', error);
        }
    }
});

function confirmarSaida(event) {
  event.preventDefault();
  const sair = confirm("Deseja realmente sair?");
  if (sair) {
    window.location.href = 'login.html';
  }
}

function getPaginaAtual() {
  const path = window.location.pathname;
  return path.substring(path.lastIndexOf('/') + 1);
}

document.addEventListener('DOMContentLoaded', () => {
  // Seleciona o link "Sair" pelo id para maior clareza e manutenção
  const sairLink = document.getElementById('link-sair');
  if (sairLink) {
    sairLink.addEventListener('click', confirmarSaida);
  }