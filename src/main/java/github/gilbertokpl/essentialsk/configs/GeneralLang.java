package github.gilbertokpl.essentialsk.configs;

import github.gilbertokpl.essentialsk.manager.IInstance;
import org.bukkit.entity.Player;

import java.util.List;

public class GeneralLang {
    private static final GeneralLang instance = createInstance();

    public static GeneralLang createInstance() {
        return new GeneralLang();
    }

    public static GeneralLang getInstance() {
        return instance;
    }

    public String generalOnlyPlayerCommand;

    public String generalNotPerm;

    public String generalNotPermAction;

    public String generalPlayerNotOnline;

    public String generalCommandsUsage;

    public String generalCommandsUsageList;

    public String generalSpecialCaracteresDisabled;

    public String generalPlayerNotExist;

    public String generalSendingInfoToDb;

    public String kitsNotExist;

    public String kitsExist;

    public String kitsCreateKitSuccess;

    public String kitsDelKitSuccess;

    public String kitsEditKitSuccess;

    public String kitsEditKitTime;

    public String kitsEditKitInventoryItemsName;

    public List<String> kitsEditKitInventoryItemsLore;

    public String kitsEditKitInventoryTimeName;

    public List<String> kitsEditKitInventoryTimeLore;

    public String kitsEditKitInventoryNameName;

    public List<String> kitsEditKitInventoryNameLore;

    public String kitsEditKitInventoryTimeMessage;

    public String kitsEditKitInventoryNameMessage;

    public String kitsInventoryIconBackName;

    public String kitsInventoryIconNextName;

    public String kitsInventoryItemsName;

    public String kitsNameLength;

    public List<String> kitsInventoryItemsLore;

    public String kitsCatchMessage;

    public String kitsCatchIcon;

    public String kitsCatchIconNotCatch;

    public String kitsInventoryIconEditKitName;

    public String kitsNotExistKits;

    public List<String> kitsCatchIconLoreNotPerm;

    public List<String> kitsCatchIconLoreTime;

    public String kitsList;

    public String kitsCatchSuccess;

    public String kitsCatchNoSpace;

    public String kitsGiveKitMessage;

    public String timeSeconds;

    public String timeSecond;

    public String timeMinutes;

    public String timeMinute;

    public String timeHours;

    public String timeHour;

    public String timeDays;

    public String timeDay;

    public String timeSecondShort;

    public String timeMinuteShort;

    public String timeHourShort;

    public String timeDayShort;

    public String nicksNameLength;

    public String nicksBlocked;

    public String nicksExist;

    public String nicksNickSuccess;

    public String nicksNickRemovedSuccess;

    public String nicksNickOtherSuccess;

    public String nicksNickOtherPlayerSuccess;

    public String nicksNickRemovedOtherSuccess;

    public String nicksNickRemovedOtherPlayerSuccess;

    public String nicksNickAlreadyOriginal;

    public String nicksNickAlreadyOriginalOther;

    public String homesNameLength;

    public String homesNameAlreadyExist;

    public String homesNameDontExist;

    public String homesSendTimeToTeleport;

    public String homesHomeRemoved;

    public String homesHomeOtherRemoved;

    public String homesHomeCreated;

    public String homesHomeOtherCreated;

    public String homesHomeLimitCreated;

    public String homesHomeWorldBlocked;

    public String homesTeleported;

    public String homesTeleportedOther;

    public String homesInTeleport;

    public String homesHomeList;

    public String homesHomeOtherList;

    public String warpsNameLength;

    public String warpsNameAlreadyExist;

    public String warpsNameDontExist;

    public String warpsSendTimeToTeleport;

    public String warpsTeleported;

    public String warpsWarpList;

    public String warpsWarpCreated;

    public String warpsWarpRemoved;

    public String tpTeleportedSuccess;

    public String tpTeleportedOtherSuccess;

    public String tpaSendSuccess;

    public String tpaOtherReceived;

    public String tpaAlreadySend;

    public String tpaNotAnyRequest;

    public String tpaRequestAccepted;

    public String tpaRequestOtherAccepted;

    public String tpaRequestOtherNoDelayAccepted;

    public String tpaAlreadyInAccept;

    public String tpaRequestDeny;

    public String tpaRequestOtherDeny;

    public String tpaSameName;

    public String echestSendSuccess;

    public String echestSendOtherSuccess;

    public String gamemodeUseSuccess;

    public String gamemodeUseOtherSuccess;

    public String gamemodeSameGamemode;

    public String gamemodeSameOtherGamemode;

    public String gamemodeSendSuccessOtherMessage;

    public String vanishSendActive;

    public String vanishSendDisable;

    public String vanishSendOtherActive;

    public String vanishSendOtherDisable;

    public String vanishSendActivatedOther;

    public String vanishSendDisabledOther;

    public String feedSendMessage;

    public String feedSendFullMessage;

    public String feedSendOtherMessage;

    public String feedSendOtherFullMessage;

    public String feedSendSuccessOtherMessage;

    public String healSendMessage;

    public String healSendFullMessage;

    public String healSendOtherMessage;

    public String healSendOtherFullMessage;

    public String healSendSuccessOtherMessage;

    public String lightSendActive;

    public String lightSendDisable;

    public String lightSendOtherActive;

    public String lightSendOtherDisable;

    public String lightSendActivatedOther;

    public String lightSendDisabledOther;

    public String backSendNotToBack;

    public String backSendSuccess;

    public String spawnSendMessage;

    public String spawnSendOtherMessage;

    public String spawnSendSucessOtherMessage;

    public String spawnSendNotSet;

    public String spawnSendSetMessage;

    public String spawnSendTimeToTeleport;

    public String spawnSendInTeleport;

    public String flySendActive;

    public String flySendDisable;

    public String flySendOtherActive;

    public String flySendOtherDisable;

    public String flySendActivatedOther;

    public String flySendDisabledOther;

    public String flySendDisabledWorld;

    public String onlineSendOnline;

    public String deathmessagesPlayerKillPlayer;

    public String deathmessagesEntityKillPlayer;

    public String deathmessagesNothingKillPlayer;

    public String deathmessagesCauseNotExist;

    public String messagesEnterMessage;

    public String messagesLeaveMessage;
}