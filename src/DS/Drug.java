package DS;

import java.io.File;

/**
 * Drug
 *
 * This class represents a record of a type of drug. Its attributes include
 * its DrugBank ID, name, the structure of its chemical species in SMILES format,
 * the URL of its DrugBank Online entry, its drug groups, and its score.
 *
 * @since October 16, 2022
 * @author Jacob Applebaum
 * @assignment 2
 * @course COSC 2P03
 * @teacher Yifeng Li
 */
public class Drug {

    private int         drugBankID;     // The DrugBank ID ('DB' removed)
    private String      genericName;    // The name of the drug species
    private String      SMILES;         // The structure of this drug's chemical species in SMILES format
    private String      url;            // The URL of this drug's DrugBank Online entry
    private String[]    drugGroups;     // The drug groups that its apart of
    private float       score;          // The score of the drug

    /** This constructor instantiates a new Drug
     * with its parameters corresponding to the
     * types of the private variables that they
     * are being assigned.
     *
     * @param id The Drug BankID ('DB' at the start must be removed)
     * @param name The name of the drug species
     * @param structure The structure of its chemical species in SMILES format
     * @param url The URL of its DrugBank Online entry
     * @param drugGroups The drug groups that its apart of
     * @param score The score of the drug
     */
    public Drug(int id, String name, String structure, String url, String[] drugGroups, float score) {
        this.drugBankID = id;
        this.genericName = name;
        this.SMILES = structure;
        this.url = url;
        this.drugGroups = drugGroups;
        this.score = score;
    }

    /** This constructor instantiates a new Drug based on the raw array of Strings
     * from the data file. Designed to be used in {@link DrugBank#readData(File)}
     *
     * @param attrs An array of strings, respectively in the form: ID (with 'DB',
     *              this method removes it), name, structure, URL, drug groups, and score.
     */
    public Drug(String[] attrs) {
        this.genericName    = attrs[0];
        this.SMILES         = attrs[1];
        this.drugBankID     = Integer.parseInt( attrs[2].substring(2) );
        this.url            = attrs[3];
        this.drugGroups     = attrs[4].split("; ");
        this.score          = Float.parseFloat( attrs[5] );
    }

    /** @returns The drugBank ID of this drug */
    public int getId() {
        return this.drugBankID;
    }

    /** Gets the attributes of this drug type in a String. */
    public String displayDrug() { // Insert a tab in between each attribute so its aligned
        String s =  drugBankID + "\t" +
                genericName + "\t" +
                url + "\t" +
                drugGroups + "\t" +
                score ;
        return s;
    }
}
