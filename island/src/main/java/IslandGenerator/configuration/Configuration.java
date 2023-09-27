package IslandGenerator.configuration;

import org.apache.commons.cli.*;




public class Configuration {

    public static final String OUTPUT = "o";
    public static final String INPUT = "i";
    public static final String MODE = "mode";
    public static final String SHAPE = "shape";
    public static final String ELEVATION_PROFILE = "altitude";
    public static final String LAKES = "lakes";
    public static final String AQUIFERS = "aquifers";
    public static final String SOIL = "soil";
    public static final String BIOME = "biomes";
    public static final String SEED = "seed";
    public static final String MAP = "map";
    public static final String CITIES = "CITIES";

    private CommandLine cli;
    public Configuration(String[] args) {
        try {
            this.cli = parser().parse(options(), args);
        } catch (ParseException pe) {
            throw new IllegalArgumentException(pe);
        }
    }

    private CommandLineParser parser() {
        return new DefaultParser();
    }

    public String input() {
        return this.cli.getOptionValue(INPUT);
    }

    public String output() {
        return this.cli.getOptionValue(OUTPUT, "output.mesh");
    }

    public String mode() { 
        return this.cli.getOptionValue(MODE); 
    }

    public String shape(){
        return this.cli.getOptionValue(SHAPE,"circle");
    }

    public String altitude(){
        return this.cli.getOptionValue(ELEVATION_PROFILE,"volcano");
    }

    public String lakes(){
        return this.cli.getOptionValue(LAKES,"4");
    }

    public String aquifers(){
        return this.cli.getOptionValue(AQUIFERS,"4");
    }

    public String soil_type(){
        return this.cli.getOptionValue(SOIL,"wet");
    }

    public String biome(){
        return this.cli.getOptionValue(BIOME,"mesa");
    }

    public String seed(){
        return this.cli.getOptionValue(SEED);
    }

    public String map(){
        return this.cli.getOptionValue(MAP,"default");
    }
    public String cities(){
        return this.cli.getOptionValue(CITIES,"5");
    }

    private Options options() {
        Options options = new Options();
        options.addOption(new Option(INPUT, true, "Input file (MESH)"));
        options.addOption(new Option(OUTPUT, true, "Output file (MESH)"));
        options.addOption(Option.builder(SHAPE).longOpt("shape").hasArg().desc("Shape of Island").build());
        options.addOption(Option.builder(MODE).longOpt("mode").hasArg().desc("MODE").build());
        options.addOption(Option.builder(ELEVATION_PROFILE).longOpt("altitude").hasArg().desc("Elevation Profile").build());
        options.addOption(Option.builder(LAKES).longOpt("lakes").hasArg().desc("Number of Lakes (Integer)").build());
        options.addOption(Option.builder(AQUIFERS).longOpt("aquifers").hasArg().desc("Number of Aquifers").build());
        options.addOption(Option.builder(SOIL).longOpt("soil").hasArg().desc("Soil Type").build());
        options.addOption(Option.builder(BIOME).longOpt("biomes").hasArg().desc("biome type").build());
        options.addOption(Option.builder(SEED).longOpt("seed").hasArg().desc("Island Seed").build());
        options.addOption(Option.builder(MAP).longOpt("map").hasArg().desc("map type of island").build());
        options.addOption(Option.builder(CITIES).longOpt("cities").hasArg().desc("how many cities").build());
        return options;
    }

}
