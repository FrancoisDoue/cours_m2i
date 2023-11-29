// const REG_MAIL = /\w+\.?\w?@\w+\.\w+/g

// let userList = [
//     "user@example.com",
//     "john.doe123@example.co.uk",
//     "alice_smith@company.net",
//     "bob+jones@email.org",
//     "contact@website.info",
//     "user@example",
//     "john.doe@.co.uk",
//     "alice@company@net",
//     "bob@jones@email.org",
//     "contact@website."
// ]

// let userMaps = userList.map((e) => REG_MAIL.test(e));

// console.log(userMaps)

const REG_TEL = /\+\d{2} \d{1}( \d{2}){4}/g;

let text = `
Le numéro de contact de notre service client est le +33 1 23 45 67 89. N'hésitez pas à nous appeler pour toute assistance.

Vous pouvez également joindre notre équipe de support technique au 01 40 50 60 70 (ou 01.41.51.61.71). Nous sommes disponibles du lundi au vendredi, de 9h à 18h.

Pour des informations générales, vous pouvez composer le 33 6 12 34 56 78. Nous sommes là pour répondre à toutes vos questions.

Si vous préférez, vous pouvez nous laisser un message vocal en appelant le 0 800 123 456. Nous vous rappellerons dès que possible.

N'oubliez pas que nos collègues du département des ventes sont joignables au +33 5 55 55 55 55. Ils seront ravis de vous aider dans vos démarches.

En cas d'urgence, veuillez appeler notre hotline au 33 9 87 65 43 21. Nous sommes disponibles 24 heures sur 24, 7 jours sur 7.
`;

const matches = [...text.matchAll(REG_TEL)];

// console.log(matches)
for(const [element, ...rest] of matches) {
    console.log(element)
}