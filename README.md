# Cave's Delight

**Cave's Delight** is an expansion mod for **Farmer's Delight** that enhances cave life with culinary adventures. It introduces new cave-dwelling plants, mushrooms, minerals, and animal products, along with an extensive set of cooking pot recipes, burgers, wraps, jellos, and more.

---

## Table of Contents

- [Features](#features)
- [Complete Item List](#complete-item-list)
- [Cooking & Brewing](#cooking--brewing)
- [World Generation](#world-generation)
- [Compatibility](#compatibility)
- [Installation](#installation)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

---

## Features

| Category | Highlights |
| :--- | :--- |
| **Plants & Blocks** | Chess Flower, Hyacinth Flower, Shimmering Mushroom, Small Shimmering Mushrooms, Deep Coal Ore |
| **Ingredients** | Amethyst Powder, Salt, Deep Coal, Deep Coal Crumbs, Chessflower Petals, Hyacinth Flower Petals, Raw Glow Lichen, Axolotl Hide |
| **Axolotl Dishes** | Raw/Cooked Ham, Raw/Cooked Slices, Glazed Ham, Stuffed Axolotl (raw/cooked/placeable), Axolotl Roll |
| **Burgers & Wraps** | Burger Buns, Axolotl Burger (single/double), Spider Burger (single/double), Infused Mushroom Burger (single/double), Infused Mushroom Wrap, Axolotl Wrap |
| **Slime Jellos** | Base + 10 colors: Red, Orange, Yellow, Green, Blue, Purple, Pink, Brown, White, Black |
| **Soups & Sweets** | Chess Flower Soup, Hyacinth Flower Soup, Cotton Candy, Glow Berry Sauce, Glow Lichen with Deep Coal, Shimmering Glow Lichen, Deep Coal Cereals |

---

## Complete Item List

The following table lists every item available in the creative tab `caves_delight`, grouped by category for better readability.

### Plants, Ores & Base Materials

| Item | Description |
| :--- | :--- |
| `Chess Flower` | Flower found in Lush Caves |
| `Chess Flower Petals` | Ingredient for Chess Flower Soup |
| `Hyacinth` | Flower found in Lush Caves |
| `Hyacinth Petals` | Ingredient for Hyacinth Flower Soup |
| `Shimmering Mushroom` | Luminous mushroom block |
| `Small Shimmering Mushrooms` | Smaller cluster variant |
| `Shimmering Mushroom Slice` | Sliced shimmering mushroom |
| `Small Shimmering Mushroom Slice` | Sliced small variant |
| `Deep Coal Ore` | Ore found in Deep Darks |
| `Deep Coal` | Raw coal material |
| `Deep Coal Crumbs` | Crushed deep coal |
| `Raw Glow Lichen` | Freshly harvested glow lichen |
| `Cooked Glow Lichen` | Cooked snack / ingredient |
| `Salt` | Crafted from dripstone |
| `Amethyst Powder` | Ground amethyst shards |

### Axolotl Products

| Item | Description |
| :--- | :--- |
| `Axolotl Hide` | Material dropped by axolotls |
| `Raw Axolotl Ham` | Raw ham cut |
| `Cooked Axolotl Ham` | Cooked ham |
| `Glazed Axolotl Ham` | Glazed ham dish |
| `Raw Axolotl Slice` | Raw sliced meat |
| `Cooked Axolotl Slice` | Cooked sliced meat |
| `Raw Stuffed Axolotl` | Uncooked stuffed axolotl |
| `Cooked Stuffed Axolotl` | Placeable feast version |
| `Stuffed Axolotl` | Dish from placeable feast |
| `Axolotl Roll` | Axolotl Sushi |

### Burgers, Buns & Wraps

| Item | Description |
| :--- | :--- |
| `Burger Bun` | Simple Burger Bun |
| `Burger Buns` | Slices Bun for recipes|
| `Spider Leg` | Raw spider leg ingredient |
| `Axolotl Burger` | Single axolotl patty burger |
| `Double Axolotl Burger` | Double patty version |
| `Spider Burger` | Single spider-leg burger |
| `Double Spider Burger` | Double version |
| `Infused Mushroom Burger` | Single mushroom-based burger |
| `Infused Double Mushroom Burger` | Double version |
| `Infused Mushroom Wrap` | Wrap with shimmering mushrooms |
| `Axolotl Wrap` | Wrap with axolotl meat |

### Slime Jellos & Sweets

| Item | Description |
| :--- | :--- |
| `Slime Jello Base` | Base ingredient for all jellos |
| `Slime Jello (Red)` | Red jello |
| `Slime Jello (Orange)` | Orange jello |
| `Slime Jello (Yellow)` | Yellow jello |
| `Slime Jello (Green)` | Green jello |
| `Slime Jello (Blue)` | Blue jello |
| `Slime Jello (Purple)` | Purple jello |
| `Slime Jello (Pink)` | Pink jello |
| `Slime Jello (Brown)` | Brown jello |
| `Slime Jello (White)` | White jello |
| `Slime Jello (Black)` | Black jello |
| `Cotton Candy` | Fluffy sweet treat |

### Soups, Sauces & Specialty Dishes

| Item | Description |
| :--- | :--- |
| `Chess Flower Soup` | Hearty soup from Chess Flower Petals |
| `Hyacinth Flower Soup` | Hearty soup from Hyacinth Flower Petals |
| `Glow Berry Sauce` | Sauce made from glow berries |
| `Deep Coal Cereals` | Breakfast dish from deep coal crumbs, restores any effects while still being nutrious |
| `Glow Lichen with Deep Coal` | Combined dish |
| `Shimmering Glow Lichen` | Glow lichen topped with shimmering mushrooms |

---

## Cooking & Brewing

- **Cooking Pot Recipes:**  
  The mod hooks into Farmer's Delight's cooking system to prepare Axolotl Ham, Axolotl Slices, Stuffed Axolotl, Chess Flower Soup, Hyacinth Flower Soup, and various other dishes using Deep Coal, Glow Lichen, and cave ingredients.  
  *(Dev note: `Custom_Model_Data` now transfers through recipes, enabling colored Axolotl items.)*

- **Brewing:**  
  Amethyst Powder is used in special brewing recipes to create the new potion effect *Echo Sight*.

---

## World Generation

- New plants, mushrooms, and Deep Coal Ore are automatically generated in suitable cave biomes using biome modifiers. No manual configuration is required.

---

## Compatibility

| Mod | Support |
| :--- | :--- |
| **Farmer's Delight** | Full integration via mixins for the cooking pot system |
| **JEI** | All recipes are displayed in the JEI menu |

---

## Installation

1. Install **NeoForge 1.21.1**.
2. Download **Farmer's Delight** (for NeoForge 1.21.1) and place it in your `mods` folder.
3. Copy the **Cave's Delight** JAR file into the `mods` folder.
4. Launch Minecraft.

---

## Development

- **Mod Loader:** NeoForge 1.21.1  
- **Language:** Java  
- **Dependencies:** Farmer's Delight (required), JEI (optional)  

---

## Contributing

Have ideas or want to report a bug? Feel free to message me on Discord: **@ryfle_**.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

*Happy exploring and cooking in the depths of Minecraft!*
