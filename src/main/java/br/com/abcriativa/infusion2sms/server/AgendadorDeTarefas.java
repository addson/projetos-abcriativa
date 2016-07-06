package br.com.abcriativa.infusion2sms.server;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.com.abcriativa.infusion2sms.apiinfusionsoft.Contato;
import br.com.abcriativa.infusion2sms.apiinfusionsoft.EscutadorDeContatosInfusionSoft;

public class AgendadorDeTarefas implements org.quartz.Job {
	
	private static final String TAG = "TEST_API_JAVA";

	public AgendadorDeTarefas() {
		
	}
	
	public static void main(String[] args) {
		
		new AgendadorDeTarefas().executaTarefaAgendada();
			
	}

	public void executaTarefaAgendada() {
		
		JobDetail job = JobBuilder.newJob(AgendadorDeTarefas.class)
				.withIdentity("escutaJob", "infusion").build();

			// Rodando a cada 30 segundos
			Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("escutaTrigger", "infusion")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1 * 30).repeatForever())
				.build();

			// schedule it
			Scheduler scheduler;
			try {
				scheduler = new StdSchedulerFactory().getScheduler();
				scheduler.start();
				scheduler.scheduleJob(job, trigger);
				
				//observar
				//scheduler.shutdown(true);
				
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		System.out.println("Escutando o infusionsoft...");
		try {
			List<Contato> contatos = new EscutadorDeContatosInfusionSoft().encontraContatosComTAG(TAG);
			for (Contato contato : contatos) {
				System.out.println(contato.toString());
			}
			
			//new EscutadorDeContatosInfusionSoft().encontraContatosComTAG(TAG);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		
	}

}
