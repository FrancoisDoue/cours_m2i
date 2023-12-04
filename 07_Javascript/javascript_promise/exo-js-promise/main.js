import { getPokemon } from "./javascript/request.js"

export const capitalize = (str) => {
    let char = str[0].toUpperCase();
    return char + str.toLowerCase().substring(1);
}



document.addEventListener('DOMContentLoaded', async () => {
    const provideCardContent = async (pokeObject) => {
        const img = document.getElementById('poke-img');
        const name = document.getElementById('poke-name');
        const height = document.getElementById('poke-height');
        const weight = document.getElementById('poke-weight');
        const type = document.getElementById('poke-types');
        const abilities = document.getElementById('abilities');
    
        type.querySelectorAll('*')?.forEach(e => e.remove());
        abilities.querySelectorAll('*')?.forEach(e => e.remove());
    
        img.src = pokeObject?.images.front_default;
        name.textContent = pokeObject?.name;
        height.textContent = pokeObject?.height + ' ft';
        weight.textContent = pokeObject?.weight + ' kg';
        pokeObject?.types.forEach(e => {
            const span = document.createElement('span');
            span.textContent = capitalize(e.type.name);
            span.dataset.pokeType = e.type.name;
            type.appendChild(span);
        })
        pokeObject?.abilities.forEach(e =>{
            const p = document.createElement('p');
            p.textContent = capitalize(e.name);
            p.dataset.pokeAbility = e.name;
            abilities.appendChild(p)
        })
        nextBtn.dataset.pokeNavigator = pokeObject?.id +1;
        prevBtn.dataset.pokeNavigator = pokeObject?.id -1;
    
    }

    const searchInput = document.getElementById('search-input');
    const searchBtn = document.getElementById('search-btn');
    const searchForm = document.getElementById('search-form');
    const prevBtn = document.getElementById('previous-btn');
    const nextBtn = document.getElementById('next-btn');
    let pokemon;

    if(pokemon = await getPokemon(1)) provideCardContent(pokemon);
    
    
    searchForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        if(searchInput.value != '' && !(searchInput.value.toLowerCase() == pokemon.name.toLowerCase() || searchInput.value == pokemon.id)){
            let request, requestText = searchInput.value;
            try{
                request = await getPokemon(requestText);
                if(request){
                    pokemon = request;
                    await provideCardContent(pokemon);
                }
            }catch(err){
                console.log(err)
            }
            searchBtn.disabled = true;
            setTimeout(() => searchBtn.disabled = false, 1100);
        }

    })

    nextBtn.addEventListener('click', async (e) => {
        let request;
        try{
            request = await getPokemon(e.target.dataset.pokeNavigator);
            if(request){
                pokemon = request;
                await provideCardContent(pokemon);
            }
        }catch(err){
            console.log(err)
        }

    })
    prevBtn.addEventListener('click', async (e) => {
        console.log(e.target.dataset.pokeNavigator)
        if(+e.target.dataset.pokeNavigator > 0){
            let request;
            try{
                request = await getPokemon(e.target.dataset.pokeNavigator);
                if(request){
                    pokemon = request;
                    await provideCardContent(pokemon);
                }
            }catch(err){
                console.log(err)
            }
        }
    })


})