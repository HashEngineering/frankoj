package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 */
public class CoinDefinition {


        public static final String coinName = "Franko";
        public static final String coinTicker = "FRK";
        public static final String coinURIScheme = "franko";
        public static final String cryptsyMarketId = "33";
        public static final String cryptsyMarketCurrency = "BTC";
        public static final String alternateExchangeInfo = "http://www.frankos.org/coin_api.php?coin_id=33";


        public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://coinplorer.com/FRK/";
        public static final String BLOCKEXPLORER_BASE_URL_TEST = "https://coinplorer.com/FRK/";

        public static final String DONATION_ADDRESS = "F85ytB5qH87aHskpauQi6YWdRZPQgNubX4";  //HashEngineering donation FRK address

        enum CoinHash {
            SHA256,
            scrypt
        };
        public static final CoinHash coinHash = CoinHash.scrypt;
        //Original Values
        public static final int TARGET_TIMESPAN = (int)(0.25 * 24 * 60 * 60);  // 720 blocks; 6 hours
        public static final int TARGET_SPACING = (int)(1 * 30);  // 30 seconds per block.

        public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  // 720 blocks

        public static final int getInterval(int height, boolean testNet) {

            return INTERVAL;
        }
        public static final int getTargetTimespan(int height, boolean testNet) {

            return TARGET_TIMESPAN;
        }
        public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
        public static final int MAX_MONEY = 11235813;                 //main.h:  MAX_MONEY
        public static final String MAX_MONEY_STRING = "11235813";     //main.h:  MAX_MONEY

        public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
        public static final BigInteger DUST_LIMIT =      Utils.toNanoCoins("0.00000100"); //main.h DUST_SOFT_LIMIT        0.00001 coins
        public static final BigInteger DUST_HARD_LIMIT = Utils.toNanoCoins("0.00000010"); //main.h DUST_HARD_LIMIT        0.000001 coins

        public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
        public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

        public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client

        public static final int Port    = 7912;       //protocol.h GetDefaultPort(testnet=false)
        public static final int TestPort = 17912;     //protocol.h GetDefaultPort(testnet=true)

        //
        //  Production
        //
        public static final int AddressHeader = 35;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
        public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
        //public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
        public static final long PacketMagic = 0x7defaced;      //// Franko: 7(lucky number) defaced.

        //Genesis Block Information from main.cpp: LoadBlockIndex
        static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long genesisBlockTime = 1368144664L;                       //main.cpp: LoadBlockIndex
        static public long genesisBlockNonce = (731837);                         //main.cpp: LoadBlockIndex
        static public String genesisHash = "19225ae90d538561217b5949e98ca4964ac91af39090d1a4407c892293e4f44f"; //main.cpp: hashGenesisBlock
        static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
        //taken from the raw data of the block explorer
        static public String genesisXInBytes = "04ffff001d01042f352f392f3230313320416964656e2077696c6c20626520612079656172206f6c6420696e2074776f206d6f6e746873";   //"5/9/2013 Aiden will be a year old in two months"
        static public String genessiXOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

        //net.cpp strDNSSeed
        static public String[] dnsSeeds = new String[] {
                "www.dirtydiggers.org",
                "seed.frankos.org",
                //"dnsseed.frankos.org", // US-EAST
                //"tokyo.briefcaseit.com", //JAPAN,TOKYO
                //"dnsseed.copiamarket.com", //US
                //"frk.dencoinpools.com",//US
                //"54.217.71.192",// == crypto-knight - bloom filters ON
                //"54.193.7.225", //== frankopedia  - bloom filters ON
                //"24.127.122.120",
                //"209.95.36.136"
                "63.246.129.56",
                "24.176.222.222",
                "213.136.68.97",
                "46.105.158.193",
                "184.4.59.2",
                "71.192.130.60",
    /*addnode=64.34.49.151:7912
    addnode=198.101.10.109:7912
    addnode=54.201.183.106:7912
    addnode=173.88.4.157
    addnode=79.165.190.244
    addnode=192.99.13.205
    addnode=195.130.216.149
    addnode=204.11.237.246:6491
    addnode=37.59.52.171:2409
    addnode=98.165.106.124
    addnode=83.11.19.246
    addnode=173.176.161.97
    */

        };

        //
        // TestNet - Franko - not tested
        //
        public static final boolean supportsTestNet = true;
        public static final int testnetAddressHeader = 112;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
        public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
        public static final long testnetPacketMagic = 0x9defaced;      //0xfc, 0xc1, 0xb7, 0xdc
        public static final String testnetGenesisHash = "62108bdd14b8452692b4c0f624d20c4d088d08646a630472345b25ec27034a28";
        static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockTime = 1368187357L;                       //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockNonce = (385607496);                         //main.cpp: LoadBlockIndex



        public static int nDifficultySwitchHeight = 400000;


        public static final boolean usingNewDifficultyProtocol(int height)
        { return height >= nDifficultySwitchHeight;}



        //main.cpp GetBlockValue(height, fee)

        public static final BigInteger GetBlockReward(int height)
        {
            return Utils.toNanoCoins(0, 25).shiftRight(height / subsidyDecreaseBlockCount);
        }

        public static int subsidyDecreaseBlockCount = 22471626;     //main.cpp GetBlockValue(height, fee)

        public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // Franko: starting difficulty is 1 / 2^12

        static public String[] testnetDnsSeeds = new String[] {
                "not supported"
        };
        //from main.h: CAlert::CheckSignature
        public static final String SATOSHI_KEY = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";
        public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";
        /** The string returned by getId() for the main, production network where people trade things. */
        public static final String ID_MAINNET = "org.franko.production";
        /** The string returned by getId() for the testnet. */
        public static final String ID_TESTNET = "org.franko.test";
        /** Unit test network. */
        public static final String ID_UNITTESTNET = "com.google.franko.unittest";

        //checkpoints.cpp Checkpoints::mapCheckpoints
        public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
        {

            checkpoints.put( 0,      new Sha256Hash("5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8"));
            checkpoints.put( 0,      new Sha256Hash("19225ae90d538561217b5949e98ca4964ac91af39090d1a4407c892293e4f44f"));
            checkpoints.put( 10,     new Sha256Hash("b98fe58aa04ca9a5a216c0bd01d952e0fff16e702d0fb512f748f201b9be26fb"));
            checkpoints.put( 100,    new Sha256Hash("56b00c7d17fd10680dfafa0617f26af75f6c2b0c11aafa9cf1b6704de2766f72"));
            checkpoints.put( 1000,   new Sha256Hash("076d62aef68a8330e5f927cdbc23d58ac1e2838877936512aa16487f098d35ca"));
            checkpoints.put( 5000,   new Sha256Hash("5b7fc427fa913510186e034e1415bdf987d37f4674c2f2fd0b492836fc58de0d")) ;
            checkpoints.put( 10000,  new Sha256Hash("d4bf99505611f97b6cf6f273a79c21c1b21b03238b06396e2e9a02f83c13d01c")) ;
            checkpoints.put( 27000,  new Sha256Hash("397e50d20f9a21f274b8787fa66ca1ebc208a1b7e5bc3a9a0e352350bd42e125"))  ;
            checkpoints.put( 27650,  new Sha256Hash("b2a25b57648bf10a81dcc3b23fb758bceb6f652d121bd44b2f3c7da3fd0f0cef"));
            checkpoints.put( 29040,  new Sha256Hash("34b4dbe94b3e1bc0f6b199ee722a9fbbb52315ae53dd37cbc949fbc84aa3c6fe"));
            checkpoints.put( 48080,  new Sha256Hash("08f789323bf5d116575c5749fa617696f88d0179faac534647abb5065abbaddf"));
            checkpoints.put( 60000,  new Sha256Hash("46ca133f715de3f8d83965487002c9cc1cebe4bb0fc10a1155fc9a6d2767293b"));
            checkpoints.put( 70000,  new Sha256Hash("1ad0aa03e8888cef8381aeea5ca679602bbb32e8245e9cd36abce77cda936bfb"));
            checkpoints.put( 80000,  new Sha256Hash("3a508431391d8203d4dd8fde8ffc529c26923cc8da9f2e64342441bb7afa940c"));
            checkpoints.put( 90000,  new Sha256Hash("8571865fb72beddf95872cbe3490aeb2b7558c7810b0a4aef9d581e249ef9d98"));
            checkpoints.put( 216802, new Sha256Hash("c946c4bdb51a240a103059f69112f301995e3a293044d3a4eff8d4c95cb0a5e1"));
            checkpoints.put( 219638, new Sha256Hash("35fcdaff88c5b989895047f2be66948618feec9ceefaa947341c4f58c55d9362"));
            checkpoints.put( 402360, new Sha256Hash("14a96abb528216321b91ac3f29918b60e9292d5cada7a047fcaeb6177c93fbe6"));
            checkpoints.put( 402376, new Sha256Hash("41f33e89e8369d88e1a516a4860fb0c1b4b8b5037f28388a9fd062e4966258f6"));
            checkpoints.put( 472665, new Sha256Hash("7b532f4e96384b2de42f73803572ae5a2bfbecf19462cf2c9f754e7421498ba0"));
            checkpoints.put( 605904, new Sha256Hash("97a0618b8971a7627eb30f3346245af28fe43e32af117b915132b8c0efb1c1f9"));
            checkpoints.put( 785863, new Sha256Hash("9ea053de310cc64a14c9b48849f9ed1e5b5898b30696f3d935b40047feb2306b"));
            checkpoints.put( 785950, new Sha256Hash("1ea42eb64c0a5027549e58d2b532e4fe5da6c901b723fd2ae2d4b7263807e8da"));
            checkpoints.put( 786082, new Sha256Hash("980e5394dee86c2d12572cff87d74b260e2e37c2ef321118cf5a7b68f15188ea"));
        }
}
