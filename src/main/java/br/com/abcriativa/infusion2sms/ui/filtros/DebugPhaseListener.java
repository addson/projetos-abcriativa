package br.com.abcriativa.infusion2sms.ui.filtros;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author Addson Bastos
 *
 */
@SuppressWarnings("serial")
public class DebugPhaseListener implements PhaseListener {

	@Override
	public void beforePhase(PhaseEvent event) {
		
		System.out.println("Antes do Evento: " + event.getPhaseId());
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		
		System.out.println("Depois do Evento: " + event.getPhaseId());
		if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
			
			System.out.println("\n");
		}

	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}
	
	
}

