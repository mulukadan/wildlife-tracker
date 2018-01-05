# Wildlife tracker


this an application that allows Rangers to track wildlife sightings in the area.

The application tracks two categories of wildlife:
- Animals

At the very least, require:

    id
    name

- Endangered Animals

Due to their dwindling numbers, Rangers must record additional information about EndangeredAnimals:

    id
    name
    health
        Am using constants to define options like "healthy", "ill", and "okay".
    age (an estimated guess by the ranger)
        Am using constants to define options like "newborn", "young", or "adult".

Each time an animal species of either category is seen, a Sighting must be reported:
Sightings

When wildlife is spotted, a Ranger submits a form to record a Sighting containing the following:

    id of Animal or EndangeredAnimal species
    location
        (Conveyed in any manner you choose ie: "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values are all acceptable.)
    rangerName

# Database Set Up!
    In PSQL:
    CREATE DATABASE wildlife_tracker;
    CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
    CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, rangername);

  
