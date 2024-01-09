import { createInterface } from "readline"
import { createClient } from "redis"
import { exit, stdin, stdout } from "process"
import Product from "./Product.js"

const HOST = "127.0.0.1"
const PORT = "6379"

const rl = createInterface(stdin, stdout)

const customPrompt = async (str) => {
    return new Promise((resolve) => {
        rl.question(str, a => resolve(a));
    })
}


const client = await createClient(PORT, HOST)
    .on('error', e => console.log("REDIS ERROR : ", e))
    .connect()

const getIndexList = async () => await client.lRange('indexList', 0, -1) ?? []
    

const addProduct = async (obj) => {
    const productExists = await client.hGetAll(`P${obj.id}`)
    if (!!productExists){
        try{
            await client.hSet(`P${obj.id}`, obj)
            await client.rPush('indexList', `P${obj.id}`)
            return true
        }catch(e){
            console.log(e)
            return false
        }
    }else {
        console.log('Le produit existe déjà')
        return false
    }
}

const addProductSubMenu = async () => {
    const nameProduct = await customPrompt('Nom du produit :  ')
    const quantityProduct = await customPrompt('Quantité du produit :  ')
    const costProduct = await customPrompt('Prix du produit :  ')
    Product.cnt = (await client.lRange('indexList', 0, -1)).length
    // console.log(Product.cnt)
    if (await addProduct((new Product(nameProduct, +quantityProduct, +costProduct)))) 
        console.log('Produit ajouté avec succès')
    else 
        console.log('Echec de l\'ajout')
}

const showProducts = async () => {
    console.log(await getIndexList());
}

const menu = async () => {
    let choice;
    do {
        console.log('\n=== GESTION DU STOCK ===\n[1] Ajouter un produit\n[2] Mettre à jour un produit\n[3] Afficher les stocks\n[4] Supprimer un produit\n[- 0 -] Quitter')
        choice = await customPrompt('==> ')
        console.log(choice)
        switch (choice) {
            case '1':
                await addProductSubMenu()
                break;
            case '2':
                await showProducts()
                break;
            case '0':
                console.log('== [  END  ] ==')
                client.disconnect()
                exit()
            default:
                console.log('\n== [ Invalid choice ] ==\n')
                break;
        }
        
    } while (choice != '0');
}

menu()