//  PIX
document.getElementById('pixForm')?.addEventListener('submit', async function(e) {
    e.preventDefault();
    const chavePix = document.getElementById('chavePix').value;
    const valorPix = document.getElementById('valorPix').value;
    try {
        const token = localStorage.getItem('token');
        const response = await fetch('http://localhost:8080/pix', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + token
            },
            body: JSON.stringify({ chavePix, valor: valorPix })
        });
        const data = await response.json();
        if (response.ok) {
            document.getElementById('pixMessage').textContent = 'PIX enviado com sucesso! QR Code: ' + data.qrCode;
        } else {
            document.getElementById('pixMessage').textContent = 'Erro ao efetuar transação PIX: ' + data.message;
        }
    } catch (error) {
        document.getElementById('pixMessage').textContent = 'Erro ao efetuar transação PIX: ' + error.message;
    }
});
