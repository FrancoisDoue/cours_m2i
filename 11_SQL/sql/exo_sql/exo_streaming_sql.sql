DROP DATABASE IF EXISTS musical_streaming;
CREATE DATABASE IF NOT EXISTS musical_streaming;

USE musical_streaming;

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    register_at TIMESTAMP NOT NULL DEFAULT NOW(),
    country VARCHAR(100)
);

CREATE TABLE song(
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    album VARCHAR(255),
    duration TIME NOT NULL,
    genre VARCHAR(100) NOT NULL,
    released_at YEAR NOT NULL
);

CREATE TABLE playlist(
	id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    playlist_title VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE song_playlist(
	song_id INT NOT NULL,
    playlist_id INT NOT NULL,
    FOREIGN KEY (song_id) REFERENCES song(id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);
