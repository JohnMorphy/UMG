import axios from "axios";
import { useState, useEffect } from "react";
import React from 'react';
import './ArtAppStyles.css';


// Api I have used uses seperate API for art data and art image;
// For that reason i need to extract iiif_url from config - basic url from image api
// and image_id to get image from that api
function ArtApp(props) {
    const [artCollection, setArt] = useState([]);
    //const [defaultImage, setDefaultImage] = useState('');
    const defaultId = 11;
    const defaultLink = "https://api.artic.edu/api/v1/artworks/"+defaultId+"?fields=id,title,image_id,config.iiif_url";

    useEffect(() => {
        const fetchData = async () => {
            const fetchedArt = [];

            for (const id of props.ids) {
                // using this link I ecstract needed image_id and title from id
                const mainLink = `https://api.artic.edu/api/v1/artworks/${id}?fields=id,title,image_id,config.iiif_url`;
                try {
                    const response = await axios.get(mainLink);
                    fetchedArt.push(response.data);
                } catch (error) {
                    console.error(`Error fetching artwork with ID ${id}:`, error);
                    try {
                        const response = await axios.get(defaultLink);
                        fetchedArt.push(response.data);
                    } catch (error) {
                        console.error(`Default artwork of ID ${id} can't be loaded:`, error);
                    }
                }
            }

            setArt(fetchedArt);
            //setDefaultImage(defaultImageLink);
        };

        fetchData();
    }, [defaultLink, props.ids]);

    return (
        <div className="container">
            {artCollection.map(art => (
                <div key={art.data.id}>
                    <img
                        className="artImage"
                        src={`${art.config.iiif_url}/${art.data.image_id}/full/400,/0/default.jpg`}
                        alt={art.title}
                    />

                    <h2>{art.data.title}</h2>
                </div>
            ))}
        </div>
    );
}

export default ArtApp;