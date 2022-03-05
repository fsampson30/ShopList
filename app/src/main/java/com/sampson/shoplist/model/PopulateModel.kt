package com.sampson.shoplist.model

import com.sampson.shoplist.R

object PopulateModel {

    fun populateCategory() : ArrayList<Category>{
        val categories = arrayListOf<Category>()
        categories.add(Category(1,"Açougue"))
        categories.add(Category(2,"Cereais"))
        categories.add(Category(3,"Bebidas"))
        categories.add(Category(4,"Laticínios"))
        categories.add(Category(5,"Farináceos"))
        categories.add(Category(6,"Temperos"))
        categories.add(Category(7,"Padaria"))
        categories.add(Category(8,"Peixaria"))
        categories.add(Category(9,"Limpeza"))
        categories.add(Category(10,"Outros"))
        return categories
    }

    fun populateItem() : ArrayList<Item> {
        val items = arrayListOf<Item>()
        items.add(Item(1,"Arroz",2))
        items.add(Item(2,"Feijão",2))
        items.add(Item(3,"Sal",2))
        items.add(Item(4,"Farinha de Trigo",5))
        items.add(Item(5,"Farinha de Mandioca",5))
        items.add(Item(6,"Farinha de Rosca",5))
        items.add(Item(7,"Ervilha",2))
        items.add(Item(8,"Picanha",1))
        items.add(Item(9,"Queijo Prato",4))
        items.add(Item(10,"Suco Natural",3))
        items.add(Item(11,"Goiabada",10))
        items.add(Item(12,"Sucrilhos",2))
        items.add(Item(13,"Creme de Leite",4))
        items.add(Item(14,"Macarrão",10))
        items.add(Item(15,"Pão de Forma",7))
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

