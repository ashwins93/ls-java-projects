package io.github.ashwins93.countries;

public class Country {
  private static int nextId = 1;
  private final int id;
  private final String name;
  private final long population;
  private final long landMass;
  private final int medianAge;

  public Country(String name, long population, long landMass, int medianAge) {
    this.id = nextId++;
    this.name = name;
    this.population = population;
    this.landMass = landMass;
    this.medianAge = medianAge;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the population
   */
  public long getPopulation() {
    return population;
  }

  /**
   * @return the landMass
   */
  public long getLandMass() {
    return landMass;
  }

  /**
   * @return the medianAge
   */
  public int getMedianAge() {
    return medianAge;
  }
}