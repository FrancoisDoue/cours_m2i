import { capitalize } from "../main.js";
import { BASE_POKEURL } from "./constantes.js"


const pokeMap = (pokeData) => {
    return {
        id : pokeData.id,
        name : capitalize(pokeData.name),
        height : pokeData.height,
        weight : pokeData.weight,
        types : pokeData.types,
        abilities : pokeData.abilities.map(e => e.ability),
        images : pokeData.sprites.other['official-artwork']
    }
}

export async function getPokemon(pokeName){
    let data;
    const response = await fetch(`${BASE_POKEURL}pokemon/${pokeName}`/*,{headers: {"Content-Type" : "application/json"}}*/);
    if (response.status === 200) {
        data = await response.json();
        return pokeMap(data)
    }else return new Error(response.status);
}
