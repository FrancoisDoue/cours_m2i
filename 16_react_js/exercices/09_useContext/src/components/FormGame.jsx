import React, { useContext, useRef, useState } from 'react';
import GameContext from '../context/GameContext';

const FormGame = () => {

    const [counter, setCounter] = useState(0)
    const { gameList, setGameList } = useContext(GameContext)

    const gameNameRef = useRef()
    const gameEditorRef = useRef()

    const handleSubmit = (e) => {
        e.preventDefault()
        setCounter(counter + 1)

        setGameList([...gameList,{
            id: counter,
            gameName: gameNameRef.current.value,
            gameEditor: gameEditorRef.current.value
        }])
        gameNameRef.current.value = ''
        gameEditorRef.current.value = ''
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="gameName">Nom : </label>
                <input type="text" name="gameName" id="gameName" ref={gameNameRef} placeholder='The Witcher' required/>
            </div>
            <div>
                <label htmlFor="gameEditor">Editeur : </label>
                <input type="text" name="gameEditor" id="gameEditor" ref={gameEditorRef} placeholder='CD Project' required/>
            </div>
            <button type="submit">Add</button>
        </form>
    );
}

export default FormGame;
