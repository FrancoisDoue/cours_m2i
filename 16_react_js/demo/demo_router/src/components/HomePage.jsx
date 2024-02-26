import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
    return (
        <div>
            <h1>Home page</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Deleniti quae eos impedit eius eveniet! Accusamus, ad, eum, esse expedita sequi molestiae omnis adipisci alias minus id ab enim nobis quis.
            Ad unde aperiam tempore assumenda numquam saepe repellat dolorum sint impedit libero autem doloremque omnis velit rem, molestias labore aut maiores ea eligendi eum facilis. Sint natus deserunt eius neque.
            Tempore quia numquam dicta a. Alias, facilis? Totam officia, rem harum a impedit autem laborum voluptate. Quas, quo? Molestiae iusto autem velit commodi laboriosam impedit nihil tempore laudantium corporis animi.
            Quasi explicabo voluptates voluptatibus eius nobis, cum itaque placeat, reiciendis temporibus exercitationem autem quis, vero dignissimos delectus eaque sit atque dolor quam? Similique fugit asperiores perferendis, explicabo totam laborum atque.
            Explicabo maiores, magnam asperiores quis veniam quasi quas, sit tempore non ipsa cumque enim omnis alias atque in iusto voluptate eos nulla. Qui ipsam placeat corrupti tenetur! Totam, provident ut?</p>
            <hr />
            <Link to={'/form'}>Un super formulaire</Link>
        </div>
    );
}

export default HomePage;
