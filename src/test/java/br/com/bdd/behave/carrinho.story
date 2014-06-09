Narrativa:
Para obter o controle sobre os itens que estão no carrinho de compras
Como um cliente
Desejo adicionar e remover produtos no carrinho de compras

Cenário: Adicionar dois produtos distintos com quantidades diferentes.
Quando o cliente adiciona '30' unidades do produto 'DVD-RW' ao carrinho
Quando o cliente adiciona '50' unidades do produto 'TV LCD' ao carrinho
Então existe dois produtos no carrinho de compra


Cenário: Calcular o preço total dos produtos que estão no carrinho
Quando o cliente adiciona '1' unidade do produto 'XBOX360' onde o custo da unidade e de '600' reais
Quando o cliente adiciona '2' unidades do produto 'TV LCD 50' onde o custo da unidade e de '4600' reais
Quando o cliente adiciona '1' unidade do produto 'IPHONE 5S' onde o custo da unidade e de '2000' reais 
Então existe tres produtos no carrinho de compra

Cenário: Somar a quantidade dos produtos que forem adicionados mais de uma vez.
Quando o cliente adiciona '30' unidades do produto 'DVD-RW' onde o custo da unidade e de '5' reais 
Quando o cliente adiciona '50' unidades do produto 'DVD-RW' onde o custo da unidade e de '5' reais 
Então existe um produto no carrinho de compra
Então o valor total dos items no carrinho e de '400' reais

