import React, { useContext } from 'react';
import GameContext from '../context/GameContext';

const GameList = () => {
    const { gameList } = useContext(GameContext)
    console.log(gameList)

    return (
        <table style={{width: '100%'}}>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Jeu </th>
                    <th>Editeur </th>
                    <th>Action</th>
                </tr>
            </thead>
            {!!gameList.length && 
                <tbody>
                    {gameList.map((e)=> (
                        <tr key={e.id}>
                            <td>{e.id}</td>
                            <td>{e.gameName}</td>
                            <td>{e.gameEditor}</td>
                            <td><button onClick={() => console.log(e)}>Log it!</button></td>
                        </tr>
                    ))}
                
                </tbody>
            }   
        </table>
    );
}

export default GameList;
