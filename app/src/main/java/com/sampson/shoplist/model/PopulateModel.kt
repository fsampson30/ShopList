package com.sampson.shoplist.model

import com.sampson.shoplist.R

object PopulateModel {

    fun populateCategory() : ArrayList<Category>{
        val categories = arrayListOf<Category>()
        categories.add(Category(1,"Açougue"))
        categories.add(Category(2,"Bebidas"))
        categories.add(Category(3,"Biscoitos"))
        categories.add(Category(4,"Cereais"))
        categories.add(Category(5,"Congelados"))
        categories.add(Category(6,"Enlatados"))
        categories.add(Category(7,"Farináceos"))
        categories.add(Category(8,"Higiene"))
        categories.add(Category(9,"Hortifruti"))
        categories.add(Category(10,"Laticínios"))
        categories.add(Category(11,"Limpeza"))
        categories.add(Category(12,"Massas"))
        categories.add(Category(13,"Matinais"))
        categories.add(Category(14,"Óleos"))
        categories.add(Category(15,"Padaria"))
        categories.add(Category(16,"Peixaria"))
        categories.add(Category(17,"Salgados"))
        categories.add(Category(18,"Temperos"))
        categories.add(Category(19,"Utilidades"))
        categories.add(Category(20,"Outros"))
        return categories
    }

    fun populateItem() : ArrayList<Item> {
        val items = arrayListOf<Item>()
        items.add(Item(	1,"Abacate",9))
        items.add(Item(2,"Abacaxi",9))
        items.add(Item(3,"Abóbora",9))
        items.add(Item(4,"Abobrinha",9))
        items.add(Item(5,"Absorvente",8))
        items.add(Item(6,"Açafrão",18))
        items.add(Item(7,"Acém",1))
        items.add(Item(8,"Achocolatado",10))
        items.add(Item(9,"Achocolatado em pó",13))
        items.add(Item(10,"Açúcar",13))
        items.add(Item(11,"Agrião",9))
        items.add(Item(12,"Água com Gás",2))
        items.add(Item(13,"Água Sanitária",11))
        items.add(Item(14,"Água sem Gás",2))
        items.add(Item(15,"Alcatra",1))
        items.add(Item(16,"Alcatra Suína",1))
        items.add(Item(17,"Álcool",11))
        items.add(Item(18,"Alface",9))
        items.add(Item(19,"Alho",9))
        items.add(Item(20,"Alho poró",9))
        items.add(Item(21,"Almôndega",5))
        items.add(Item(22,"Alvejante",11))
        items.add(Item(23,"Amaciante",11))
        items.add(Item(24,"Amendoim",4))
        items.add(Item(25,"Amido de Milho",7))
        items.add(Item(26,"Antisséptico bucal",8))
        items.add(Item(27,"Argola",12))
        items.add(Item(28,"Arroz Arbório",4))
        items.add(Item(29,"Arroz Branco",4))
        items.add(Item(30,"Arroz Integral",4))
        items.add(Item(31,"Arroz Parboilizado",4))
        items.add(Item(32,"Asa de Frango",5))
        items.add(Item(33,"Atum",6))
        items.add(Item(34,"Azeite",14))
        items.add(Item(35,"Bacalhau",17))
        items.add(Item(36,"Bacia",11))
        items.add(Item(37,"Balde",11))
        items.add(Item(38,"Banana",9))
        items.add(Item(39,"Batata",9))
        items.add(Item(40,"Batata Baroa",9))
        items.add(Item(41,"Berinjela",9))
        items.add(Item(42,"Biscoito Maisena",3))
        items.add(Item(43,"Biscoito Polvilho",3))
        items.add(Item(44,"Biscoito Recheado",3))
        items.add(Item(45,"Biscoito Wafer",3))
        items.add(Item(46,"Bloco Higiênico",11))
        items.add(Item(47,"Brócolis",9))
        items.add(Item(48,"Cachaça",2))
        items.add(Item(49,"Café",13))
        items.add(Item(50,"Café solúvel",13))
        items.add(Item(51,"Caldo de carne",18))
        items.add(Item(52,"Caldo de legumes",18))
        items.add(Item(53,"Camarão cinza",16))
        items.add(Item(54,"Canela",18))
        items.add(Item(55,"Canelone",12))
        items.add(Item(56,"Cápsula de café",13))
        items.add(Item(57,"Carne Moída",1))
        items.add(Item(58,"Carne seca",17))
        items.add(Item(59,"Catchup",18))
        items.add(Item(60,"Cebola",9))
        items.add(Item(61,"Cebolinha",9))
        items.add(Item(62,"Cenoura",9))
        items.add(Item(63,"Cera",11))
        items.add(Item(64,"Cereal matinal",13))
        items.add(Item(65,"Cerveja",2))
        items.add(Item(66,"Chá",2))
        items.add(Item(67,"Condicionador",8))
        items.add(Item(68,"Contra Filé",1))
        items.add(Item(69,"Cookie",3))
        items.add(Item(70,"Coração de Frango",5))
        items.add(Item(71,"Costela",1))
        items.add(Item(72,"Couve",9))
        items.add(Item(73,"Couve flor",9))
        items.add(Item(74,"Coxa de Frango",5))
        items.add(Item(75,"Cream Cheese",10))
        items.add(Item(76,"Cream Cracker",3))
        items.add(Item(77,"Creme para assaduras",8))
        items.add(Item(78,"Creme para barbear",8))
        items.add(Item(79,"Creme para pentear",8))
        items.add(Item(80,"Desinfetante",11))
        items.add(Item(81,"Desodorante",8))
        items.add(Item(82,"Detergente",11))
        items.add(Item(83,"Energético",2))
        items.add(Item(84,"Ervilha",6))
        items.add(Item(85,"Ervilha Seca",4))
        items.add(Item(86,"Escova de Dente",8))
        items.add(Item(87,"Espaguete",12))
        items.add(Item(88,"Espinafre",9))
        items.add(Item(89,"Esponja",11))
        items.add(Item(90,"Esponja de aço",11))
        items.add(Item(91,"Espuma para barbear",8))
        items.add(Item(92,"Extrato de tomate",18))
        items.add(Item(93,"Farinha de Mandioca",7))
        items.add(Item(94,"Farinha de Rosca",7))
        items.add(Item(95,"Farinha de Trigo",7))
        items.add(Item(96,"Farofa Pronta",7))
        items.add(Item(97,"Feijão Branco",4))
        items.add(Item(98,"Feijão Fradinho",4))
        items.add(Item(99,"Feijão Manteiga",4))
        items.add(Item(100,"Feijão Marrom",4))
        items.add(Item(101,"Feijão Preto",4))
        items.add(Item(102,"Feijão Vermelho",4))
        items.add(Item(103,"Fermento",7))
        items.add(Item(104,"Fetutine",12))
        items.add(Item(105,"Filé de merluza",16))
        items.add(Item(106,"Filé de tilápia",16))
        items.add(Item(107,"Filet Mignon",1))
        items.add(Item(108,"Filet Mignon Suíno",1))
        items.add(Item(109,"Filtro de café",19))
        items.add(Item(110,"Fio dental",8))
        items.add(Item(111,"Fita dental",8))
        items.add(Item(112,"Flanela",11))
        items.add(Item(113,"Fralda",8))
        items.add(Item(114,"Fraldinha",1))
        items.add(Item(115,"Fubá",7))
        items.add(Item(116,"Gelatina",13))
        items.add(Item(117,"Geléia",13))
        items.add(Item(118,"Geléia de mocotó",13))
        items.add(Item(119,"Gim",2))
        items.add(Item(120,"Goiabada",6))
        items.add(Item(121,"Grão de Bico",4))
        items.add(Item(122,"Guardanapo",11))
        items.add(Item(123,"Guraná Natural",2))
        items.add(Item(124,"Hastes Flexíveis",8))
        items.add(Item(125,"Hidratante",8))
        items.add(Item(126,"Hortelã",9))
        items.add(Item(127,"Inhame",9))
        items.add(Item(128,"Inseticida",11))
        items.add(Item(129,"Iogurte",10))
        items.add(Item(130,"Kibe",5))
        items.add(Item(131,"Lã de aço",11))
        items.add(Item(132,"Lagarto Redondo",1))
        items.add(Item(133,"Lâmina de barbear",8))
        items.add(Item(134,"Laranja",9))
        items.add(Item(135,"Lasanha",5))
        items.add(Item(136,"Lasanha",12))
        items.add(Item(137,"Lava Roupas em pó",11))
        items.add(Item(138,"Lava Roupas líquido",11))
        items.add(Item(139,"Leite",10))
        items.add(Item(140,"Leite",13))
        items.add(Item(141,"Leite Condensado",6))
        items.add(Item(142,"Leite em Pó",10))
        items.add(Item(143,"Leite em pó",13))
        items.add(Item(144,"Lentilha",4))
        items.add(Item(145,"Limão",9))
        items.add(Item(146,"Limpa vidros",11))
        items.add(Item(147,"Limpador Multiuso",11))
        items.add(Item(148,"Lingüiça calabresa",17))
        items.add(Item(149,"Lombo",17))
        items.add(Item(150,"Lombo Suíno",1))
        items.add(Item(151,"Louro",9))
        items.add(Item(152,"Lustra Móveis",11))
        items.add(Item(153,"Luva",11))
        items.add(Item(154,"Maçã",9))
        items.add(Item(155,"Macarrão instanâneo",12))
        items.add(Item(156,"Maionese",18))
        items.add(Item(157,"Maminha",1))
        items.add(Item(158,"Manga",9))
        items.add(Item(159,"Manteiga",10))
        items.add(Item(160,"Maracujá",9))
        items.add(Item(161,"Margarina",10))
        items.add(Item(162,"Massa para pizza",12))
        items.add(Item(163,"Mate em Pó",2))
        items.add(Item(164,"Mate Garrafa",2))
        items.add(Item(165,"Mel",13))
        items.add(Item(166,"Melancia",9))
        items.add(Item(167,"Melão",9))
        items.add(Item(168,"Milho",6))
        items.add(Item(169,"Milho para Pipoca",4))
        items.add(Item(170,"Molho de Alho",18))
        items.add(Item(171,"Molho de Pimenta",18))
        items.add(Item(172,"Molho de tomate",18))
        items.add(Item(173,"Molho Inglês",18))
        items.add(Item(174,"Molho Tabasco",18))
        items.add(Item(175,"Mostarda",18))
        items.add(Item(176,"Músculo",1))
        items.add(Item(177,"Mussarela",10))
        items.add(Item(178,"Nuggets",5))
        items.add(Item(179,"Óleo de Girassol",14))
        items.add(Item(180,"Óleo de Soja",14))
        items.add(Item(181,"Óleo misto",14))
        items.add(Item(182,"Orégano",18))
        items.add(Item(183,"Ovos",9))
        items.add(Item(184,"Pá",1))
        items.add(Item(185,"Padre Nosso",12))
        items.add(Item(186,"Paio",17))
        items.add(Item(187,"Palmito",6))
        items.add(Item(188,"Pano Multiuso",11))
        items.add(Item(189,"Pão Bisnaga",15))
        items.add(Item(190,"Pão Bisnaguinha",15))
        items.add(Item(191,"Pão de Cachorro Quente",15))
        items.add(Item(192,"Pão de forma",15))
        items.add(Item(193,"Pão de forma preto",15))
        items.add(Item(194,"Pão de Hambúrguer",15))
        items.add(Item(195,"Pão francês",15))
        items.add(Item(196,"Pão Integral",15))
        items.add(Item(197,"Papel Higiênico",8))
        items.add(Item(198,"Papel Toalha",11))
        items.add(Item(199,"Parafuso",12))
        items.add(Item(200,"Pasta de Dente",8))
        items.add(Item(201,"Patinho",1))
        items.add(Item(202,"Peito",1))
        items.add(Item(203,"Peito de Frango",5))
        items.add(Item(204,"Penne",12))
        items.add(Item(205,"Pepino",9))
        items.add(Item(206,"Pera",9))
        items.add(Item(207,"Pernil Suíno",1))
        items.add(Item(208,"Pêssego em Calda",6))
        items.add(Item(209,"Picanha",1))
        items.add(Item(210,"Picanha Suína",1))
        items.add(Item(211,"Pimentão",9))
        items.add(Item(212,"Pizza",5))
        items.add(Item(213,"Purificador de ar",11))
        items.add(Item(214,"Queijo Branco",10))
        items.add(Item(215,"Queijo Prato",10))
        items.add(Item(216,"Queijo Ralado",10))
        items.add(Item(217,"Rabanete",9))
        items.add(Item(218,"Ravioli",12))
        items.add(Item(219,"Refrigerante",2))
        items.add(Item(220,"Repolho",9))
        items.add(Item(221,"Requeijão",10))
        items.add(Item(222,"Ricota",10))
        items.add(Item(223,"Rigatone",12))
        items.add(Item(224,"Rodo",11))
        items.add(Item(225,"Rosquinha",3))
        items.add(Item(226,"Rúcula",9))
        items.add(Item(227,"Sabão",11))
        items.add(Item(228,"Sabão Líquido",11))
        items.add(Item(229,"Sabonete",8))
        items.add(Item(230,"Sabonete líquido",8))
        items.add(Item(231,"Saco de lixo 100L",19))
        items.add(Item(232,"Saco de lixo 10L",19))
        items.add(Item(233,"Saco de lixo 15L",19))
        items.add(Item(234,"Saco de lixo 30L",19))
        items.add(Item(235,"Saco de lixo 50L",19))
        items.add(Item(236,"Sal",17))
        items.add(Item(237,"Salgadinho",3))
        items.add(Item(238,"Salmão",16))
        items.add(Item(239,"Salsa",9))
        items.add(Item(240,"Salsinha",9))
        items.add(Item(241,"Sardinha",6))
        items.add(Item(242,"Shampoo",8))
        items.add(Item(243,"Sobrecoxa de Frango",5))
        items.add(Item(244,"Sobrepaleta Suína",1))
        items.add(Item(245,"Suco em Pó",2))
        items.add(Item(246,"Suco Natural",2))
        items.add(Item(247,"Talco",8))
        items.add(Item(248,"Talharim",12))
        items.add(Item(249,"Tangerina",9))
        items.add(Item(250,"Tapioca",7))
        items.add(Item(251,"Tempero pronto alho e sal",18))
        items.add(Item(252,"Tequila",2))
        items.add(Item(253,"Tintura para cabelo",8))
        items.add(Item(254,"Tomate",9))
        items.add(Item(255,"Uva",9))
        items.add(Item(256,"Vassoura",11))
        items.add(Item(257,"Vinagre Balsâmico",14))
        items.add(Item(258,"Vinagre de álcool",14))
        items.add(Item(259,"Vinagre de arroz",14))
        items.add(Item(260,"Vinagre de maçã",14))
        items.add(Item(261,"Vinho",2))
        items.add(Item(262,"Vodka",2))
        items.add(Item(263,"Whisky",2))
        return items
    }

    fun populateMarket() : ArrayList<Market> {
        val markets = arrayListOf<Market>()
        markets.add(Market("Guanabara","https://www.supermercadosguanabara.com.br/encarte", R.drawable.guanabara))
        markets.add(Market("Mundial","https://www.supermercadosmundial.com.br/encarte", R.drawable.mundial))
        markets.add(Market("Prezunic","https://www.prezunic.com.br/ofertas/encartes/", R.drawable.prezunic))
        markets.add(Market("Rede Economia","https://www.redeconomia.com.br/ofertas/encarte/", R.drawable.redeconomia))
        markets.add(Market("Super Market","https://smpravc.com.br/encartes/", R.drawable.supermarket))
        markets.add(Market("Hortifruti","https://www.hortifruti.com.br/", R.drawable.hortifruti))
        markets.add(Market("SuperPrix","https://www.superprix.com.br/", R.drawable.superprix))
        markets.add(Market("Zona Sul","https://www.zonasul.com.br/", R.drawable.zonasul))
        markets.add(Market("Pão de Açucar","https://www.paodeacucar.com/", R.drawable.paodeacucar))
        markets.add(Market("Costazul","https://www.costazulsupermercados.com.br/encarte/", R.drawable.costazul))
        markets.add(Market("Assai","https://www.assai.com.br/ofertas/rio-de-janeiro/assai-tijuca/", R.drawable.assai))
        return markets
    }
}

