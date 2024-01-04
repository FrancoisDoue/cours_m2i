### LIEUX
|LieuId| Lieu |
|-|-|
|L01|Centre des Congrès|
|L02|Hôtel de Ville|

### TYPES_EVENEMENTS
| TypeEvenementId |TypeEvenement |
|-|-|
|TE01|Conférence|
|TE02|Séminaire|

### PARTICIPANTS
|ParticipantId|NomParticipant|EmailParticipant|
|-|-|-|
|P01|Jean Dupont|jean.dupont@email.co|
|P02|Marie Curie| marie.curie@email.com|
|P03|Albert Einstein|albert.einstein@email.com|
|P04|Isaac Newton|isaac.newton@email.com|

### PROGRAMME
| EvenementId | Date | TypeEvenementId | LieuId |
|-|-|-|-|
|E01|2021-09-15|TE01|L01|
|E02|2021-09-20|TE02|L02|

### PROGRAMME_PARTICIPANTS
|EvenementId|ParticipantId|
|-|-|
|E01|P01|
|E01|P04|
|E02|P02|
|E02|P03|