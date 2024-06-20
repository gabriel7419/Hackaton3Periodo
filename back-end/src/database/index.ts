import * as mysql from 'mysql2/promise';

const db = mysql.createPool({
<<<<<<< HEAD
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'vacinacao'
=======
host: 'localhost',
user: 'root',
password: '',
database: 'vacinacao'
>>>>>>> 2319c3b568c6423c1f18ecd9563f6aa3a6f0f719
});

export default db;
