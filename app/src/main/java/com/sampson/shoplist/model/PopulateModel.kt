package com.sampson.shoplist.model

class PopulateModel {

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
}