
## Features

### Character Statistics
- **Read Character Data**: Reads characters and their elemental types from a text file (`personajes.txt`).
- **Unique Element Identification**: Determines all unique elemental types.
- **Statistical Analysis**:
  - Total number of characters.
  - Total unique elements used (excluding neutral elements, such as `E`).
  - Distribution of characters by elemental type.
- **Output Statistics**: Saves detailed statistics to `EstadisticasPersonajes.txt`.

### Elemental Reactions
- **Combination Processing**: Reads element combinations from `elementos.txt`.
- **Reaction Rules**: Calculates the result of combining two elements:
  - Example rules include:
    - `F + A` → "Evaporación"
    - `R + A` → "Electro-carga"
    - `F + R` → "Sobrecarga"
  - See full reaction logic in the code.
- **Reaction Results**: Saves reactions to `ResultadosElementales.txt`.

---

## How It Works

### Input Files
- **`rsrcs/personajes.txt`**:
  - Format:
    ```
    CharacterName ElementType
    ```
    - Example:
      ```
      Pyro F
      Hydro H
      Anemo A
      ```

- **`rsrcs/elementos.txt`**:
  - Contains sequences of elemental characters for combination analysis.

### Output Files
- **`EstadisticasPersonajes.txt`**: Summary of character statistics.
- **`ResultadosElementales.txt`**: List of elemental reactions.

