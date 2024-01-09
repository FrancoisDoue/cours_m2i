import { createInterface } from "readline"
import { exit, stdin, stdout } from "process"
import Product from "./Product.js"

const rl = createInterface(stdin, stdout)
const rlPrompt = async (str) => {
    return new Promise((resolve) => {
        rl.question(str, a => resolve(a));
    })
}

const addProductSubMenu = async () => {
    const nameProduct = await rlPrompt('Nom du produit : ')
    const costProduct = +(await rlPrompt('Prix du produit : '))
    const quantityProduct = +(await rlPrompt('Quantité du produit : '))
    const product = new Product(nameProduct, quantityProduct, costProduct)
    console.log(product.toString())
    // let quantityProduct, costProduct
    // do{
    //     costProduct = +(await rlPrompt('Prix du produit : '))
    //     quantityProduct = +(await rlPrompt('Quantité du produit : '))
    // }while(isNaN(quantityProduct) || isNaN(costProduct) )
}

const menu = async () => {
    let choice;
    do {
        console.log('\n=== GESTION DU STOCK ===\n[1] Ajouter un produit\n[2] Mettre à jour un produit\n[3] Afficher les stocks\n[4] Supprimer un produit\n[- 0 -] Quitter')
        choice = await rlPrompt('==> ')
        console.log(choice)
        switch (choice) {
            case '1':
                await addProductSubMenu()
                break;
            case '2':

                break;
            case '3':
                
                break;
            case '4':
                
                break;
            case '0':
                console.log('== [  END  ] ==')
                exit()
            default:
                console.log('\n== [ Invalid choice ] ==\n')
                break;
        }
        
    } while (choice != '0');
}
menu()