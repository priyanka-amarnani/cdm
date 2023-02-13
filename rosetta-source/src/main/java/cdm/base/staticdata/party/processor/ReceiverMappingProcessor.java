package cdm.base.staticdata.party.processor;

import cdm.legaldocumentation.contract.processor.PartyMappingHelper;
import com.regnosys.rosetta.common.translation.MappingContext;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.path.RosettaPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import static cdm.base.staticdata.party.processor.CreditPartyMappingHelper.isCreditFundingLeg;
import static cdm.base.staticdata.party.processor.CreditPartyMappingHelper.isFra;

/**
 * FpML mapping processor.
 */
@SuppressWarnings("unused")
public class ReceiverMappingProcessor extends PayerReceiverMappingProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverMappingProcessor.class);

	public ReceiverMappingProcessor(RosettaPath modelPath, List<Path> synonymPaths, MappingContext context) {
		super(modelPath, synonymPaths, context);
	}

	@Override
	void setCounterparty(Path synonymPath, PayerReceiverBuilder builder, PartyMappingHelper helper) {
		helper.setCounterpartyRoleEnum(getModelPath(), synonymPath, builder::setReceiver);
	}
}
