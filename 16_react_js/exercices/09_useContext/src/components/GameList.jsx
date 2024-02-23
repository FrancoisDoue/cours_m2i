import React, { useContext } from 'react';
import GameContext from '../context/GameContext';

const GameList = () => {
    const { gameList } = useContext(GameContext)
    console.log(gameList)

    return (
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Jeu  </th>
                    <th>Editeur  </th>
                </tr>
            </thead>
            {!!gameList.length && 
                <tbody>
                    {gameList.map((e)=> (
                        <tr key={e.id}>
                            <td>{e.id}</td>
                            <td>{e.gameName}</td>
                            <td>{e.gameEditor}</td>
                        </tr>
                    ))}
                
                </tbody>
            }   
        </table>
    );
}

export default GameList;
